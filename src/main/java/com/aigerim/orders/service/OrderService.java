package com.aigerim.orders.service;

import com.aigerim.orders.exception.ResourceNotFoundException;
import com.aigerim.orders.model.*;
import com.aigerim.orders.repository.CustomerRepository;
import com.aigerim.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order create(Long customerId, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id " + customerId));

        Order order = new Order();
        order.setCustomer(customer);
        order.setAmount(amount);

        return orderRepository.save(order);
    }

    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id " + id));
    }

    public Order update(Long id, BigDecimal amount) {
        Order order = getById(id);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        order.setAmount(amount);
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        Order order = getById(id);
        orderRepository.delete(order);
    }

    public Order pay(Long id) {
        Order order = getById(id);

        if (order.getStatus() != OrderStatus.NEW) {
            throw new IllegalArgumentException("Only NEW orders can be paid");
        }

        order.setStatus(OrderStatus.PAID);
        return orderRepository.save(order);
    }

    public Order cancel(Long id) {
        Order order = getById(id);

        if (order.getStatus() == OrderStatus.PAID) {
            throw new IllegalArgumentException("Paid orders cannot be cancelled");
        }

        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
    public Page<Order> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}