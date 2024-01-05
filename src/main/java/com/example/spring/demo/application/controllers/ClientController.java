package com.example.spring.demo.application.controllers;

import com.example.spring.demo.domain.model.Client;
import com.example.spring.demo.infrastructure.toggle.Features;
import com.example.spring.demo.domain.ports.in.ClientManagementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientManagementPort clientManagementService;
    private final FeatureManager featureManager;

    @Autowired
    public ClientController(ClientManagementPort clientManagementService, FeatureManager featureManager) {
        this.clientManagementService = clientManagementService;
        this.featureManager = featureManager;
    }

    @PostMapping
    public ResponseEntity<Client> createProduct(@RequestBody Client client) {
        Client createdClient = clientManagementService.createClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping
    public ResponseEntity<Boolean> check() {
        return ResponseEntity.ok(featureManager.isActive(Features.CPF_VALIDATOR));
    }
}
