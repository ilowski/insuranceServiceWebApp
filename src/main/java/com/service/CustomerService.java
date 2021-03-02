package com.service;

import com.entity.Customer;
import com.entity.dto.PolicyForProfileDto;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer findById(long id);

    PolicyForProfileDto findPoliciesOfCustomer(String pesel);

    void addCustomer(Customer customer);

    List<Customer> findByCriteria(String criteria, String searchItem);

    boolean removeCustomer(long id);

    boolean removeCustomerByPesel(String pesel);

    Boolean updateCustomer(Customer customer);

    Customer findByPesel(String pesel);
}
