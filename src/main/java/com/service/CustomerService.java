package com.service;

import com.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Page<Customer> findAllCustomers(Pageable pageable);

    public Optional<Customer> findById(Long id);

    public void addCustomer(Customer customer) throws Exception;

    public List<Customer> findByCriteria(String criteria, String searchItem);

    public Boolean removeCustomer(Long id);

    public Boolean updateCustomer(Customer customer);
}
