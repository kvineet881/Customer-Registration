package com.edusol.banking.app.controller;

import com.edusol.banking.app.entity.Customer;
import com.edusol.banking.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Welcome in Spring Boot";
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer()
    {
     return customerService.getAllCustomer();
    }
    @GetMapping("/getCustomerById")
    public Optional<Customer> getCustomerById(@RequestParam("id") int id)
    {
        return customerService.getCustomerById(id);
    }


    @DeleteMapping("/deleteCustomerById")
    public int deleteCustomerById(@RequestParam("id") int id,Customer customer)
    {
        customerService.deleteCustomerById(id);
        return customer.getCustomerId();
    }

    @PostMapping("/createCustomer")
   public int saveCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
        return customer.getCustomerId();
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer, @RequestParam("id") int id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/deleteAllCustomer")
    public void deleteAllcustomer()
    {
        customerService.deleteAllcustomer();
    }




}
