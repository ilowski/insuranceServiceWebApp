package com.controller;

import com.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final Customer DEFAULT_CUSTOMER = new Customer(0l, "Not found", "Not found");

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> findAllCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.findAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
        return new ResponseEntity<Customer>(Optional.ofNullable(customerService.findById(id)).orElse(DEFAULT_CUSTOMER), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCustomer(@PathVariable Long id) {
        if (customerService.removeCustomer(id)) {
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
