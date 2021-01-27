package com.repository;

import com.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findBySecondName(String secondName);
    public List<Customer> findByPesel(String pesel);


}
