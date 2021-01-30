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
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    public Optional<Policy> findByNumberOfPolicy(String numberOfPolicy);

    public List<Policy> findByInsuranceCompany(String insuranceCompany);

    public List<Policy> findByCustomerId(Long customerId);

    public List<Policy> findByTypeOfPolicy(String typeOfPolicy);

    public List<Policy> findByDateOfStartPolicy(Date dateOfStartPolicy);

    @Query(value = "select * from Policies where datediff(curdate(),date_of_end_policy)>=14",
    nativeQuery = true)
    public List<Policy> findTwoWeeksPolicies();


    public List<Policy> findByDateOfEndPolicy(Date dateOfEndPolicy);
}
