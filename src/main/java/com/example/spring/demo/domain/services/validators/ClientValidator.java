package com.example.spring.demo.domain.services.validators;

import com.example.spring.demo.domain.model.Client;
public interface ClientValidator {

    void validate(Client client);

    boolean isActive();

}
