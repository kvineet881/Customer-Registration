package com.edusol.banking.app.dao;

import com.edusol.banking.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer>, JpaRepository<Customer, Integer> {

    @Query("select c From Customer c where c.lastName like %:lastName%")
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);

    // @Query("select c From Customer c where c.firstName like %:firstName%")

    List<Customer> findCustomerByFirstName(String firstName);

    @Query("select e from Customer e where e.mobile like %:mobile%")
    List<Customer> findCustomerContainingMobile(String mobile);

    @Query("select e from Customer e where e.email like %:email% order by e.customerId desc ")
    List<Customer> findCustomerContainingEmial(String email);

    List<Customer> findCustomerByCity(String city);

    List<Customer> getCustomerByCityOrderByCustomerIdDesc(String city);
}
