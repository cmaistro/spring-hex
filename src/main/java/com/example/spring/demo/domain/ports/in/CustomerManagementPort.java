package com.example.spring.demo.domain.ports.in;

import com.example.spring.demo.domain.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerManagementPort {

    Customer createClient(Customer customer);
    Customer getById(UUID id);

    Customer getByEmail(String email);
    List<Customer> listAll();

    void delete(UUID id);

}
