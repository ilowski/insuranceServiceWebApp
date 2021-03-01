package com.validator;

import com.entity.Customer;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator implements ConstraintValidator<PeselConstraint, String> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (Customer x : customerRepository.findAll()) {
            if (x.getPesel().equals(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void initialize(PeselConstraint constraintAnnotation) {

    }
}
