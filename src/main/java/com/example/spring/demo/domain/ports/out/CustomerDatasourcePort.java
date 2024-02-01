package com.example.spring.demo.domain.ports.out;

import com.example.spring.demo.domain.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDatasourcePort {

    Customer save(Customer customer);
    Customer getById(UUID id);
    Customer getByEmail(String email);
    List<Customer> findAll();
    void delete(Customer customer);

}
