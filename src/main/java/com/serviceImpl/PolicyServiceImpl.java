package com.serviceImpl;

import com.entity.Customer;
import com.entity.Policy;
import com.repository.PolicyRepository;
import com.service.PolicyService;
import com.validator.PolicyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    PolicyValidator policyValidator;

    @Override
    public Page<Policy> findAllPolicies(Pageable pageable) {
        return policyRepository.findAll(pageable);
    }



    @Override
    public void addPolicy(Policy policy) throws Exception {

        if (policyValidator.isPolicyValid(policy)) {
            policyRepository.save(policy);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Policy> findByCriteria(String criteria, String searchItem) {
        switch(criteria) {
            case "insuranceCompany" : return policyRepository.findByInsuranceCompany(searchItem);
            case "typeOfPolicy" : return policyRepository.findByTypeOfPolicy(searchItem);
            case "customerId" : return policyRepository.findByCustomerId(Long.parseLong(searchItem));
            case "dateOfStartPolicy" : return policyRepository.findByDateOfStartPolicy(Date.valueOf(searchItem));
            case "dateOfEndPolicy" : return policyRepository.findByDateOfEndPolicy(Date.valueOf(searchItem));
        }
        return new ArrayList<>();
    }


    @Override
    public Boolean removePolicy(String numberOfPolicy) {
        for (Policy x : policyRepository.findAll()) {
            if (x.getNumberOfPolicy().equals(numberOfPolicy)) {
                policyRepository.delete(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updatePolicy(Policy policy) {
        for (Policy x : policyRepository.findAll()) {
            if (x.getNumberOfPolicy().equals(policy.getNumberOfPolicy())) {
                x.setInsuranceCompany(policy.getInsuranceCompany());
                x.setCustomerId(policy.getCustomerId());
                x.setTypeOfPolicy(policy.getTypeOfPolicy());
                policyRepository.save(policy);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Policy> findByNumberOfPolicy(String numberOfPolicy) {
        return policyRepository.findByNumberOfPolicy(numberOfPolicy);
    }
}
