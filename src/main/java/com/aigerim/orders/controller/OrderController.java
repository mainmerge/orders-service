package com.aigerim.orders.controller;

import com.aigerim.orders.model.Order;
import com.aigerim.orders.service.OrderService;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestParam Long customerId,
                        @RequestParam @DecimalMin("0.01") BigDecimal amount) {
        return service.create(customerId, amount);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id,
                        @RequestParam @DecimalMin("0.01") BigDecimal amount) {
        return service.update(id, amount);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{id}/pay")
    public Order pay(@PathVariable Long id) {
        return service.pay(id);
    }

    @PostMapping("/{id}/cancel")
    public Order cancel(@PathVariable Long id) {
        return service.cancel(id);
    }
    @GetMapping
    public Page<Order> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }
}