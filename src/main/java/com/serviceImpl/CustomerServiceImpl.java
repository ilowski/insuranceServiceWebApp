package com.serviceImpl;

import com.entity.Customer;
import org.springframework.stereotype.Service;
import com.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static List<Customer> listCustomers = new ArrayList<>();

    private static Long COUNTER = 1l;

    static {
        listCustomers.add(new Customer(COUNTER++, "Adam", "Boczek"));
        listCustomers.add(new Customer(COUNTER++, "Magda", "Kozak"));
        listCustomers.add(new Customer(COUNTER++, "Grazyna", "Zdziek"));
        listCustomers.add(new Customer(COUNTER++, "Bartosz", "Kox"));
    }

    @Override
    public List<Customer> findAllCustomers() {

        return listCustomers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer x : listCustomers) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setId(COUNTER++);
        listCustomers.add(customer);
    }

    @Override
    public Boolean removeCustomer(Long id) {
        for (Customer x : listCustomers) {
            if (x.getId() == id) {
                listCustomers.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        for (Customer x : listCustomers) {
            if (x.getId() == customer.getId()) {
                x.setFirstName(customer.getFirstName());
                x.setSecondName(customer.getSecondName());
                return true;
            }
        }
        return false;
    }
}