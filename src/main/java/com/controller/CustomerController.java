package com.controller;

import com.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    private final Customer DEFAULT_CUSTOMER = new Customer(0l,"Default","Customer");

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return Optional.ofNullable(customerService.findById(id)).orElse(DEFAULT_CUSTOMER);
    }
}
