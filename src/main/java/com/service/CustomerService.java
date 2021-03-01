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
    List<Customer> findAllCustomers();

    Customer findById(long id);

    PolicyForProfileDto findPoliciesOfCustomer(String pesel);

    void addCustomer(Customer customer);

    List<Customer> findByCriteria(String criteria, String searchItem);

    Boolean removeCustomer(Long id);

    Boolean updateCustomer(Customer customer);

    Customer findByPesel(String pesel);
}
