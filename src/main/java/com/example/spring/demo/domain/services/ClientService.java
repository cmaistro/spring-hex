package com.example.spring.demo.domain.services;

import com.example.spring.demo.domain.model.Client;
import com.example.spring.demo.domain.services.validators.ClientValidator;
import com.example.spring.demo.domain.ports.in.ClientManagementPort;
import com.example.spring.demo.domain.ports.out.ClientRepositoryPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService implements ClientManagementPort {

    private ClientRepositoryPort clientRepository;
    private List<ClientValidator> validators;

    @Autowired
    public ClientService(ClientRepositoryPort clientRepository, List<ClientValidator> validators) {
        this.clientRepository = clientRepository;
        this.validators = validators;
    }

    public Client createClient(Client client) {

        for (ClientValidator validator : validators.stream()
                .filter(ClientValidator::isActive)
                .toArray(ClientValidator[]::new)) {
            validator.validate(client);
        }

        return clientRepository.save(client);
    }

    public Client getById(UUID id) {
        return clientRepository.getById(id);
    }

    public Client getByEmail(String email) {
        return clientRepository.getByEmail(email);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public void delete(UUID id) {
        Client client = clientRepository.getById(id);
        clientRepository.delete(client);
    }

}
