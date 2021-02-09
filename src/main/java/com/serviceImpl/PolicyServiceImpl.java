package com.serviceImpl;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyBasicInfoDto;
import com.repository.CustomerRepository;
import com.repository.PolicyRepository;
import com.service.PolicyService;
import com.validator.PolicyValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private PolicyValidator policyValidator;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<Policy> findAll() {return policyRepository.findAll();
    }



    @Override
    public void addPolicy(PolicyBasicInfoDto policyBasicInfoDto) throws Exception {

        Customer customer = customerRepository.findByPesel(policyBasicInfoDto.getCustomer().getPesel());
        if (customer == null) {
            customer = new Customer();
            customer.setFirstName(policyBasicInfoDto.getCustomer().getFirstName());
            customer.setSecondName(policyBasicInfoDto.getCustomer().getSecondName());
            customer.setPesel(policyBasicInfoDto.getCustomer().getPesel());
        }

        Policy policy = new Policy(
                policyBasicInfoDto.getNumberOfPolicy(),
                policyBasicInfoDto.getTypeOfPolicy(),
                policyBasicInfoDto.getInsuranceCompany(),
                policyBasicInfoDto.getDateOfStartPolicy(),
                policyBasicInfoDto.getDateOfEndPolicy(),
                customer
        );
        if (policyValidator.isPolicyValid(policy)) {
            policyRepository.save(policy);
        } else {
            throw new Exception();
        }
    }


    @Override
    public List<Policy> findByCriteria(String criteria, String searchItem)  {
        switch (criteria) {
            case "insuranceCompany":
                return policyRepository.findByInsuranceCompany(searchItem);
            case "typeOfPolicy":
                return policyRepository.findByTypeOfPolicy(searchItem);
            case "dateOfStartPolicy":
                return policyRepository.findByDateOfStartPolicy(searchItem);
            case "dateOfEndPolicy":
                return policyRepository.findByDateOfEndPolicy(searchItem);
        }
        return new ArrayList<>();
    }


    @Override
    public Boolean removePolicy(String numberOfPolicy) {
        if (policyRepository.findByNumberOfPolicy(numberOfPolicy) != null) {
            policyRepository.delete(policyRepository.findByNumberOfPolicy(numberOfPolicy));
            return true;
        }
    return false;

    }


    @Override
    public Boolean updatePolicy(Policy policy) {
        if(policyRepository.findByNumberOfPolicy(policy.getNumberOfPolicy()) != null)  {
            Policy updatePolicy = policyRepository.findByNumberOfPolicy(policy.getNumberOfPolicy());
            updatePolicy.setTypeOfPolicy(policy.getTypeOfPolicy());
            updatePolicy.setDateOfEndPolicy(policy.getDateOfEndPolicy());
            updatePolicy.setCustomer(policy.getCustomer());
            updatePolicy.setInsuranceCompany(policy.getInsuranceCompany());
            updatePolicy.setDateOfStartPolicy(policy.getDateOfStartPolicy());
            policyRepository.save(updatePolicy);
            return true;
        }

        return false;
}

    @Override
    public Policy findByNumberOfPolicy(String numberOfPolicy) {
        return policyRepository.findByNumberOfPolicy(numberOfPolicy);
    }


    @Override
    public PolicyBasicInfoDto convertToPolicyBasicInfoDto(Policy policy) {
        PolicyBasicInfoDto policyBasicInfoDto = modelMapper.map(policy,PolicyBasicInfoDto.class);
        return policyBasicInfoDto;
    }
}
