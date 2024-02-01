package com.example.spring.demo.infrastructure.toggle.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;

import java.lang.reflect.Type;
import java.util.HashMap;

@Component
public class CustomStateRepository implements StateRepository {

    private final FeatureToggleRepository featureToggleRepository;

    private Gson gson;

    public CustomStateRepository(FeatureToggleRepository featureToggleRepository) {
        gson= new Gson();
        this.featureToggleRepository = featureToggleRepository;
    }

    @Override
    public FeatureState getFeatureState(org.togglz.core.Feature feature) {
        FeatureToggleEntity entity = featureToggleRepository.findById(feature.name()).orElse(null);
        if (entity == null) {
            return null;
        }
        var ret = new FeatureState(feature, entity.isEnabled());
        ret.setStrategyId(entity.getStrategyId());

        HashMap<String,String> map = gson.fromJson(entity.getParameters(), HashMap.class);
        for(Object key : map.keySet()) {
            ret.setParameter(key.toString(), map.get(key));
        }

        return ret;
    }

    @Override
    public void setFeatureState(FeatureState featureState) {
        FeatureToggleEntity entity = new FeatureToggleEntity();
        entity.setFeatureName(featureState.getFeature().name());
        entity.setEnabled(featureState.isEnabled());
        entity.setStrategyId(featureState.getStrategyId());


        Type typeObject = new TypeToken<HashMap>() {}.getType();
        String gsonData = gson.toJson(featureState.getParameterMap(), typeObject);
        entity.setParameters(gsonData);
        featureToggleRepository.save(entity);
    }
}
