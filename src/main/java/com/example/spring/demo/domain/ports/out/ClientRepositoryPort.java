package com.example.spring.demo.domain.ports.out;

import com.example.spring.demo.domain.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientRepositoryPort {

    Client save(Client client);
    Client getById(UUID id);
    Client getByEmail(String email);
    List<Client> findAll();
    void delete(Client client);

}
