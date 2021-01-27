package com.repository;

import com.entity.Customer;
import com.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    public Optional<Policy> findByNumberOfPolicy(String numberOfPolicy);

    public List<Policy> findByInsuranceCompany(String insuranceCompany);

    public List<Policy> findByCustomerId(Long customerId);

    public List<Policy> findByTypeOfPolicy(String typeOfPolicy);

    public List<Policy> findByDateOfStartPolicy(Date dateOfStartPolicy);

    public List<Policy> findByDateOfEndPolicy(Date dateOfEndPolicy);
}
