package com.validator;

import com.entity.Customer;
import com.entity.Policy;
import com.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PolicyValidator {

    @Autowired
    PolicyRepository policyRepository;

    public boolean isPolicyValid(Policy policy) {
        return isNumberOfPolicyUnique(policy.getNumberOfPolicy()) && dateOfEndPolicyIsNotNull(policy.getDateOfEndPolicy())
                && dateOfStartPolicyIsNotNull(policy.getDateOfStartPolicy()) && typeOfPolicyIsNotNull(policy.getTypeOfPolicy())
                && numberOfPolicyIsNotNull(policy.getNumberOfPolicy()) && insuranceCompanyIsNotNull(policy.getInsuranceCompany())
                && customerIdIsNotNull(policy.getCustomerId());
    }

    public boolean isNumberOfPolicyUnique(String numberOfPolicy) {
        for (Policy x : policyRepository.findAll()) {
            if (x.getNumberOfPolicy().equals(numberOfPolicy) ) {
                return false;
            }
        }
        return true;
    }

    public boolean dateOfStartPolicyIsNotNull(Date dateOfStartPolicy) { return dateOfStartPolicy != null; }
    public boolean dateOfEndPolicyIsNotNull(Date dateOfEndPolicy) { return dateOfEndPolicy != null;}
    public boolean typeOfPolicyIsNotNull (String typeOfPolicy) {return typeOfPolicy != null && !typeOfPolicy.isEmpty();}
    public boolean numberOfPolicyIsNotNull (String numberOfPolicy) {return numberOfPolicy != null && !numberOfPolicy.isEmpty();}
    public boolean insuranceCompanyIsNotNull(String insuranceCompany) { return insuranceCompany != null && !insuranceCompany.isEmpty();}
    public boolean customerIdIsNotNull (Long customerId) {return customerId != null;}


}
