package com.edusol.banking.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@NamedNativeQuery(name="getCustomerByLastName",
//  query="select * From Customer c where c.lastName = :lastName",
// resultClass = Customer.class)

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String firstName;
    private String lastName;
    private String city;
    private String mobile;
    private String email;

}
