package com.validator;

import com.entity.Policy;
import com.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberOfPolicyValidator implements ConstraintValidator<NumberOfPolicyConstraint, String> {

    @Autowired
    PolicyRepository policyRepository;

    @Override
    public void initialize(NumberOfPolicyConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (Policy x : policyRepository.findAll()) {
            if (x.getNumberOfPolicy().equals(value)) {
                return false;
            }
        }
        return value != null;
    }
}
