package com.example.spring.demo.infrastructure.toggle;

import com.example.spring.demo.domain.ports.out.FeatureTogglePort;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

@Service
public class FeatureToggleService implements FeatureTogglePort {

    private final FeatureManager featureManager;

    public FeatureToggleService(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @Override
    public boolean isFeatureActive(Features feature) {
        return featureManager.isActive(feature);
    }
}
