package com.repository;

import com.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>, CrudRepository<Customer, Long> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findBySecondName(String secondName);

    Customer findByPesel(String pesel);

    Customer findById(long id);

    void deleteByPesel(String pesel);


}
