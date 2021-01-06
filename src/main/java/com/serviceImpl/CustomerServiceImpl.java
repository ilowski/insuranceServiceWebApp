package com.serviceImpl;

import com.entity.Customer;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {

        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Boolean removeCustomer(Long id) {
        for (Customer x : customerRepository.findAll()) {
            if (x.getId() == id) {
                customerRepository.delete(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        for (Customer x : customerRepository.findAll()) {
            if (x.getId() == customer.getId()) {
                x.setFirstName(customer.getFirstName());
                x.setSecondName(customer.getSecondName());
                customerRepository.save(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Customer> findByCriteria(String criteria, String searchItem) {
        switch(criteria) {
            case "firstname" : return customerRepository.findByFirstName(searchItem);
            case "secondname" : return customerRepository.findBySecondName(searchItem);
        }
        return new ArrayList<>();
    }
}