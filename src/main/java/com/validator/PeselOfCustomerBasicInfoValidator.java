package com.validator;

import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselOfCustomerBasicInfoValidator implements ConstraintValidator<PeselOfCustomerBasicInfoConstraint, String> {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return customerRepository.findByPesel(value) != null;
    }

    @Override
    public void initialize(PeselOfCustomerBasicInfoConstraint constraintAnnotation) {

    }
}
