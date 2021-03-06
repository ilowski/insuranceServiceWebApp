package com.controller;

import com.entity.Customer;
import com.entity.dto.CustomerBasicInfoForPolicyDto;
import com.entity.dto.CustomerFullInfoForProfileDto;
import com.entity.dto.PolicyForProfileDto;
import com.validator.ErrorWrapper;
import com.validator.MethodArgumentNotValidExceptionHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @Autowired
    ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<?> findAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<List<CustomerBasicInfoForPolicyDto>>(customers.stream().map(customer -> modelMapper.map(customer, CustomerBasicInfoForPolicyDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria,
                                            @RequestParam(name = "searchItem", required = true) String searchItem) {
        return new ResponseEntity<List<Customer>>(customerService.findByCriteria(criteria, searchItem), HttpStatus.OK);
    }

    @GetMapping("/profile/{pesel}")
    public ResponseEntity<?> getProfileCustomer(@PathVariable String pesel) {
        Customer customer = customerService.findByPesel(pesel);
        PolicyForProfileDto policyForProfileDto = customerService.findPoliciesOfCustomer(pesel);
        CustomerFullInfoForProfileDto customerFull = new CustomerFullInfoForProfileDto(customer.getId(), customer.getFirstName(), customer.getSecondName(), customer.getPesel(), customer.getAddress(), customer.getPhoneNumber(), customer.getAdditionalInformation(), policyForProfileDto.getNumberOfPolicy());
        return new ResponseEntity<CustomerFullInfoForProfileDto>(customerFull,HttpStatus.OK);
    }

    @GetMapping("/{pesel}")
    public ResponseEntity<?> findByCustomerPesel (@PathVariable String pesel) {
        Customer customer = customerService.findByPesel(pesel);
        if (customer != null) {
            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer) {


        customerService.addCustomer(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);


    }

    @DeleteMapping("/remove/{pesel}")
    public ResponseEntity<?> removeCustomer(@PathVariable String pesel) {
        if (customerService.removeCustomer(pesel)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer) {
        if (customerService.updateCustomer(customer)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}



















































