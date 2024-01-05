package com.example.spring.demo.infrastructure.toggle.db;

import org.springframework.stereotype.Component;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;

@Component
public class CustomStateRepository implements StateRepository {

    private final FeatureToggleRepository featureToggleRepository;

    public CustomStateRepository(FeatureToggleRepository featureToggleRepository) {
        this.featureToggleRepository = featureToggleRepository;
    }

    @Override
    public FeatureState getFeatureState(org.togglz.core.Feature feature) {
        FeatureToggleEntity entity = featureToggleRepository.findById(feature.name()).orElse(null);
        if (entity == null) {
            return null;
        }
        return new FeatureState(feature, entity.isEnabled());
    }

    @Override
    public void setFeatureState(FeatureState featureState) {
        FeatureToggleEntity entity = new FeatureToggleEntity();
        entity.setFeatureName(featureState.getFeature().name());
        entity.setEnabled(featureState.isEnabled());
        featureToggleRepository.save(entity);
    }
}
