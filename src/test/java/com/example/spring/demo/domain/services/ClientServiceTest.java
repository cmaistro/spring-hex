package com.example.spring.demo.domain.services;

import com.example.spring.demo.domain.model.Client;
import com.example.spring.demo.domain.services.validators.ClientValidator;
import com.example.spring.demo.domain.ports.in.ClientManagementPort;
import com.example.spring.demo.domain.ports.out.ClientRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
class ClientServiceTest {

    @Mock
    private ClientRepositoryPort clientRepository;

    @Mock
    private ClientValidator validator;

    private ClientManagementPort clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        List<ClientValidator> validators = new ArrayList<>();
        validators.add(validator);
        clientService = new ClientService(clientRepository, validators);

    }

    @Test
    void save() {
        Client client = new Client();
        client.setName("John");
        client.setEmail("john@example.com");

        when(clientRepository.save(client)).thenReturn(client);

        Client savedClient = clientService.createClient(client);

        verify(clientRepository).save(client);
    }

    @Test
    void getById() {
        UUID clientId = UUID.randomUUID();
        Client client = new Client();
        client.setId(clientId);

        when(clientRepository.getById(clientId)).thenReturn(client);

        Client retrievedClient = clientService.getById(clientId);

        verify(clientRepository).getById(clientId);
    }

    @Test
    void getByEmail() {
        String email = "john@example.com";
        Client client = new Client();
        client.setEmail(email);

        when(clientRepository.getByEmail(email)).thenReturn(client);

        Client retrievedClient = clientService.getByEmail(email);

        verify(clientRepository).getByEmail(email);
    }

    @Test
    void listAll() {
    }

    @Test
    void delete() {
    }
}