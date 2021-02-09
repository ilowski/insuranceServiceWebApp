package com.service;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyBasicInfoDto;
import com.entity.dto.PolicyForProfileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> findAllCustomers();

    public Customer findById(long id);

    public PolicyForProfileDto findPoliciesOfCustomer(String pesel);

    public void addCustomer(Customer customer) throws Exception;

    public List<Customer> findByCriteria(String criteria, String searchItem);

    public Boolean removeCustomer(Long id);

    public Boolean updateCustomer(Customer customer);

    public Customer findByPesel (String pesel);
}
