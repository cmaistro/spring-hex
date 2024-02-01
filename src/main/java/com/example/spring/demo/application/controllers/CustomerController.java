package com.example.spring.demo.application.controllers;

import com.example.spring.demo.domain.model.Customer;
import com.example.spring.demo.infrastructure.toggle.Features;
import com.example.spring.demo.domain.ports.in.CustomerManagementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerManagementPort customerManagementService;
    private final FeatureManager featureManager;

    @Autowired
    public CustomerController(CustomerManagementPort customerManagementService, FeatureManager featureManager) {
        this.customerManagementService = customerManagementService;
        this.featureManager = featureManager;
    }

    @PostMapping
    public ResponseEntity<Customer> createProduct(@RequestBody Customer customer) {
        Customer createdCustomer = customerManagementService.createClient(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping
    public ResponseEntity<Boolean> check() {
        return ResponseEntity.ok(featureManager.isActive(Features.CPF_VALIDATOR));
    }
}
