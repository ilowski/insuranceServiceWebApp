package com.serviceImpl;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyBasicInfoDto;
import com.entity.dto.PolicyForProfileDto;
import com.repository.CustomerRepository;
import com.service.PolicyService;
import com.validator.CustomerValidator;
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

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private PolicyService policyService;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {

        if (customerValidator.isCustomerValid(customer)) {
            customerRepository.save(customer);
        } else {
            throw new Exception();
        }
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
    public PolicyForProfileDto findPoliciesOfCustomer(String pesel) {
      PolicyForProfileDto policyForProfileDto = new PolicyForProfileDto();
        for (Policy x : policyService.findAll()) {
            if (x.getCustomer().getPesel().equals(pesel)) {
                policyForProfileDto.getNumberOfPolicy().add(x.getNumberOfPolicy());
            }
        }
        return policyForProfileDto;

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
        switch (criteria) {
            case "firstName":
                return customerRepository.findByFirstName(searchItem);
            case "secondName":
                return customerRepository.findBySecondName(searchItem);


        }
        return new ArrayList<>();
    }

    @Override
    public Customer findByPesel(String pesel) {
        return customerRepository.findByPesel(pesel);
    }
}