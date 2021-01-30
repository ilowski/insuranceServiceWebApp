package com.controller;

import com.entity.Customer;
import com.entity.Policy;
import com.service.PolicyService;
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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public ResponseEntity<?> findAllPolicies() {
        return new ResponseEntity<List<Policy>>(policyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/searchTwoWeeksPolicies")
    public ResponseEntity<?> findTwoWeeksPolicies () {
        return new ResponseEntity<List<Policy>>(policyService.findTwoWeeksPolicies(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria,
                                            @RequestParam(name = "searchItem", required = true) String searchItem) {
        try{
        return new ResponseEntity<List<Policy>>(policyService.findByCriteria(criteria, searchItem), HttpStatus.OK); }
        catch (ParseException e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }

    }


    @PostMapping("/add")
    public ResponseEntity<?> addPolicy(@RequestBody Policy policy) {
        try {
            policyService.addPolicy(policy);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{numberOfPolicy}")
    public ResponseEntity<?> findByNumberOfPolicy(@PathVariable String numberOfPolicy) {
        Optional<Policy> policyOptional = policyService.findByNumberOfPolicy(numberOfPolicy);
        if (policyOptional.isPresent()) {
            return new ResponseEntity<>(policyOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove/{id}")
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
