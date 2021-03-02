package com.serviceImpl;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyForProfileDto;
import com.repository.CustomerRepository;
import com.service.PolicyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.CustomerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

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
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public boolean removeCustomer(long id) {
        Customer customerToDelete = customerRepository.findById(id);
        if (customerToDelete != null) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean removeCustomerByPesel(String pesel) {
        Customer customerToDelete = customerRepository.findByPesel(pesel);
        if (customerToDelete != null) {
            customerRepository.deleteByPesel(pesel);
            return true;
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
        Customer customerToUpdate = customerRepository.findById(customer.getId().longValue());
        if (customerToUpdate.getId() == customer.getId()) {
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setSecondName(customer.getSecondName());
            customerToUpdate.setAddress(customer.getAddress());
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            customerRepository.save(customer);
            return true;
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