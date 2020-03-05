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

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/getCustomerById")
    public Optional<Customer> getCustomerById(@RequestParam("id") int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getCustomerByLastName")
    public List<Customer> getCustomerByLastName(@RequestParam("lastName") String lastName) {
        return customerService.getCustomerByLastName(lastName);
    }

    @GetMapping("/getCustomerByFirstName")
    public List<Customer> getCustomerByFirstName(@RequestParam("firstName") String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

    @GetMapping("/findCustomerContainingMobile")
    public List<Customer> findCustomerContainingMobile(@RequestParam("mobile") String mobile) {
        return customerService.findCustomerContainingMobile(mobile);
    }

    @GetMapping("/findCustomerContainingEmial")
    public List<Customer> findCustomerContainingEmial(@RequestParam("email") String email) {
        return customerService.findCustomerContainingEmial(email);
    }

    @GetMapping("/findCustomerByCity")
    public List<Customer> findCustomerByCity(@RequestParam("city") String city) {
        return customerService.findCustomerByCity(city);
    }

    @GetMapping("/getCustomerByCityOrderByCustomerIdDesc")
    List<Customer> getCustomerByCityOrderByCustomerIdDesc(@RequestParam("city") String city) {
        return customerService.getCustomerByCityOrderByCustomerIdDesc(city);
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

    @DeleteMapping("/deleteCustomerById")
    public int deleteCustomerById(@RequestParam("id") int id, Customer customer) {
        customerService.deleteCustomerById(id);
        return customer.getCustomerId();
    }

    @DeleteMapping("/deleteAllCustomer")
    public void deleteAllcustomer() {

        customerService.deleteAllcustomer();
    }


}
