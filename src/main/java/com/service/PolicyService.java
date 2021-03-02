package com.service;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyBasicInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PolicyService {

    List<Policy> findAll();


    Policy findByNumberOfPolicy(String numberOfPolicy);


    void addPolicy(PolicyBasicInfoDto policy);

    List<Policy> findByCriteria(String criteria, String searchItem);

    Boolean removePolicy(String numberOfPolicy);

    Boolean updatePolicy(Policy policy);

    PolicyBasicInfoDto convertToPolicyBasicInfoDto(Policy policy);

    List<Policy> findTwoWeeksPolicies();

    List<Policy> findByCustomerId(Long customerId);


}
