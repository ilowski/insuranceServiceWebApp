package com.controller;

import com.entity.Customer;
import com.entity.Policy;
import com.entity.dto.PolicyBasicInfoDto;
import com.service.PolicyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/policies")
public class PolicyController {


    private PolicyService policyService;

    private ModelMapper modelMapper;

    @Autowired
    public PolicyController(PolicyService policyService, ModelMapper modelMapper) {
        this.policyService = policyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> findAllPolicies() {
        List<Policy> policies = policyService.findAll();
        return new ResponseEntity<List<PolicyBasicInfoDto>>(policies.stream().map(policy -> modelMapper.map(policy, PolicyBasicInfoDto.class)).collect(Collectors.toList()),HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria,
                                            @RequestParam(name = "searchItem", required = true) String searchItem) {
        List<Policy> policies = policyService.findByCriteria(criteria, searchItem);
        return new ResponseEntity<List<PolicyBasicInfoDto>>(policies.stream().map(policy -> modelMapper.map(policy, PolicyBasicInfoDto.class)).collect(Collectors.toList()), HttpStatus.OK); }




    @PostMapping("/add")
    public ResponseEntity<?> addPolicy(@Valid @RequestBody PolicyBasicInfoDto policy) {
        try {
            policyService.addPolicy(policy);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{numberOfPolicy}")
    public ResponseEntity<?> findByNumberOfPolicy(@PathVariable String numberOfPolicy) {
       PolicyBasicInfoDto policyBasicInfoDto = policyService.convertToPolicyBasicInfoDto(policyService.findByNumberOfPolicy(numberOfPolicy));
        if (policyBasicInfoDto != null) {
            return new ResponseEntity<>(policyBasicInfoDto, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove/{numberOfPolicy}")
    public ResponseEntity<?> removePolicy(@PathVariable String numberOfPolicy) {
        if (policyService.removePolicy(numberOfPolicy)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> updatePolicy(@Valid @RequestBody Policy policy) {
        if (policyService.updatePolicy(policy)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
