package com.example.spring.demo.domain.services.validators;

import com.example.spring.demo.domain.exceptions.InvalidRequestDataException;
import com.example.spring.demo.domain.model.Customer;
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
    public void validate(Customer customer) {
        if (customer.getCPF() == null || customer.getCPF().isEmpty()) {
            throw new InvalidRequestDataException("CPF is required");
        }
    }

    public boolean isActive() {
        return featureManager.isActive(Features.CPF_VALIDATOR);
    }

}
