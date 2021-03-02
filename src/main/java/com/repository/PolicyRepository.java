package com.repository;

import com.entity.Customer;
import com.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, String> {
    Policy findByNumberOfPolicy(String numberOfPolicy);

    List<Policy> findByInsuranceCompany(String insuranceCompany);

    List<Policy> findByTypeOfPolicy(String typeOfPolicy);


    List<Policy> findByDateOfStartPolicy(java.sql.Date dateOfStartPolicy);

    void deleteByNumberOfPolicy(String numberOfPolicy);


    List<Policy> findByDateOfEndPolicy(java.sql.Date dateOfEndPolicy);

    @Query("select policy from Policy policy where datediff(policy.dateOfEndPolicy,curdate())<=14")
    List<Policy> findTwoWeeksPolicy();


    List<Policy> findByCustomerId(Long customerId);

}
