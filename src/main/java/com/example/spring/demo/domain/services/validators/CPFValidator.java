package com.example.spring.demo.domain.services.validators;

import com.example.spring.demo.domain.model.Client;
import com.example.spring.demo.infrastructure.toggle.Features;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

@Service
public class CPFValidator implements ClientValidator {

    private final FeatureManager featureManager;

    public CPFValidator(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @Override
    public void validate(Client client) {
        if (client.getCPF() == null || client.getCPF().isEmpty()) {
            throw new IllegalArgumentException("CPF is required");
        }
    }

    public boolean isActive() {
        return featureManager.isActive(Features.CPF_VALIDATOR);
    }

}
