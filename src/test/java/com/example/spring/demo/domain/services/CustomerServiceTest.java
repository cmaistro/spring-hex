package com.example.spring.demo.domain.services;

import com.example.spring.demo.domain.model.Customer;
import com.example.spring.demo.domain.services.validators.ClientValidator;
import com.example.spring.demo.domain.ports.in.CustomerManagementPort;
import com.example.spring.demo.domain.ports.out.CustomerDatasourcePort;
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
class CustomerServiceTest {

    @Mock
    private CustomerDatasourcePort clientRepository;

    @Mock
    private ClientValidator validator;

    private CustomerManagementPort clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        List<ClientValidator> validators = new ArrayList<>();
        validators.add(validator);
        clientService = new CustomerService(clientRepository, validators);

    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setEmail("john@example.com");

        when(clientRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = clientService.createClient(customer);

        verify(clientRepository).save(customer);
    }

    @Test
    void getById() {
        UUID clientId = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setId(clientId);

        when(clientRepository.getById(clientId)).thenReturn(customer);

        Customer retrievedCustomer = clientService.getById(clientId);

        verify(clientRepository).getById(clientId);
    }

    @Test
    void getByEmail() {
        String email = "john@example.com";
        Customer customer = new Customer();
        customer.setEmail(email);

        when(clientRepository.getByEmail(email)).thenReturn(customer);

        Customer retrievedCustomer = clientService.getByEmail(email);

        verify(clientRepository).getByEmail(email);
    }

    @Test
    void listAll() {
    }

    @Test
    void delete() {
    }
}