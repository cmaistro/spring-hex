package com.example.spring.demo.domain.services.validators;

import com.example.spring.demo.domain.model.Customer;
public interface ClientValidator {

    void validate(Customer customer);

    boolean isActive();

}
