package com.aigerim.orders.service;

import com.aigerim.orders.exception.ResourceNotFoundException;
import com.aigerim.orders.model.Customer;
import com.aigerim.orders.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id " + id));
    }

    public Customer update(Long id, Customer updatedCustomer) {
        Customer existing = getById(id);

        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Customer existing = getById(id);
        repository.delete(existing);
    }
    public Page<Customer> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}