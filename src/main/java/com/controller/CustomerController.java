package com.controller;

import com.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/customers")
public class CustomerController {

    private final Customer DEFAULT_CUSTOMER = new Customer(0L, "Not found", "Not found");

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> findAllCustomers(Pageable pageable) {
        return new ResponseEntity<Page<Customer>>(customerService.findAllCustomers(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria,
                                            @RequestParam(name = "searchItem", required = true) String searchItem) {
        return new ResponseEntity<List<Customer>>(customerService.findByCriteria(criteria, searchItem),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            return new ResponseEntity<Customer>(customerOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
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



















































