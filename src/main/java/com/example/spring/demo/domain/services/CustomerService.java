package com.example.spring.demo.domain.services;

import com.example.spring.demo.domain.model.Customer;
import com.example.spring.demo.domain.services.validators.ClientValidator;
import com.example.spring.demo.domain.ports.in.CustomerManagementPort;
import com.example.spring.demo.domain.ports.out.CustomerDatasourcePort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerManagementPort {

    private final CustomerDatasourcePort clientRepository;
    private final List<ClientValidator> validators;

    public Customer createClient(Customer customer) {

        for (ClientValidator validator : validators.stream()
                .filter(ClientValidator::isActive)
                .toArray(ClientValidator[]::new)) {
            validator.validate(customer);
        }

        return clientRepository.save(customer);
    }

    public Customer getById(UUID id) {
        return clientRepository.getById(id);
    }

    public Customer getByEmail(String email) {
        return clientRepository.getByEmail(email);
    }

    public List<Customer> listAll() {
        return clientRepository.findAll();
    }

    public void delete(UUID id) {
        Customer customer = clientRepository.getById(id);
        clientRepository.delete(customer);
    }

}
