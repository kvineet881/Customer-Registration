package com.edusol.banking.app.service;

import com.edusol.banking.app.dao.CustomerRepository;
import com.edusol.banking.app.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer-> customers.add(customer));
        return customers;
    }


    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);

    }

    public Customer updateCustomer(Customer customer, int id) {
        return customerRepository.findById(id)
                .map(cust -> {
                    cust.setFirstName(customer.getFirstName());
                    cust.setLastName(customer.getLastName());
                    cust.setEmail(customer.getEmail());
                    cust.setCity(customer.getCity());
                    cust.setMobile(customer.getMobile());
                    return customerRepository.save(customer);
                })
                .orElseGet(() ->
                {
                    customer.setCustomerId(id);
                    return customerRepository.save(customer);
                });

    }


    public void deleteAllcustomer() {
        customerRepository.deleteAll();
    }

    public void deleteCustomerbyName(Customer customer)
    {
        customerRepository.delete(customer);
    }
}
