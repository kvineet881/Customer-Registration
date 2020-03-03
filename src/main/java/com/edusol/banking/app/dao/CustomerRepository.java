package com.edusol.banking.app.dao;

import com.edusol.banking.app.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
