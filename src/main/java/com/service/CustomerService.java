package com.service;

import com.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> findAllCustomers();

    public Customer findById(Long id);

    public void addCustomer(Customer customer);

    public Boolean removeCustomer(Long id);

    public Boolean updateCustomer(Customer customer);
}
