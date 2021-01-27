package com.service;

import com.entity.Customer;
import com.entity.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PolicyService {

    public Page<Policy> findAllPolicies(Pageable pageable);


    public Optional<Policy> findByNumberOfPolicy(String numberOfPolicy);


    public void addPolicy(Policy policy) throws Exception;

    public List<Policy> findByCriteria (String criteria, String searchItem);

    public Boolean removePolicy(String numberOfPolicy);

    public Boolean updatePolicy(Policy policy);

}
