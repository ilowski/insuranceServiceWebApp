package com.validator;

import com.entity.Customer;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

@Component
public class CustomerValidator {
    private final int PESEL_LENGTH = 11;
    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;


    public boolean isPeselUnique(String pesel) {
        for (Customer x : customerRepository.findAll()) {
            if (x.getPesel().equals(pesel)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCustomerValid(Customer customer) {
        return isPeselValid(customer.getPesel()) && firstNameIsNotNull(customer.getFirstName()) && secondNameIsNotNull(customer.getSecondName());
    }

    public boolean firstNameIsNotNull(String firstName) {
        return firstName != null && !firstName.isEmpty();
    }

    public boolean secondNameIsNotNull(String secondName) {
        return secondName != null && !secondName.isEmpty();
    }


    public boolean isPeselValid(String pesel) {
        return pesel.length() == PESEL_LENGTH && isPeselUnique(pesel);
    }


}

