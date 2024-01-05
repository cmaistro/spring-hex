package com.example.spring.demo.domain.ports.in;

import com.example.spring.demo.domain.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientManagementPort {

    Client createClient(Client client);
    Client getById(UUID id);

    Client getByEmail(String email);
    List<Client> listAll();

    void delete(UUID id);

}
