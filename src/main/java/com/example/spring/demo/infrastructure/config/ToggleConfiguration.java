package com.example.spring.demo.infrastructure.config;

import com.example.spring.demo.infrastructure.toggle.Features;
import com.example.spring.demo.infrastructure.toggle.db.CustomStateRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.Feature;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

@Configuration
public class ToggleConfiguration implements TogglzConfig {

    private final CustomStateRepository customStateRepository;

    public ToggleConfiguration(CustomStateRepository customStateRepository) {
        this.customStateRepository = customStateRepository;
    }

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(Features.class);
    }

    @Bean
    public FeatureManager featureManager() {
        FeatureManager manager = new FeatureManagerBuilder()
                .featureClass(getFeatureClass())
                .stateRepository(getStateRepository())
                .userProvider(getUserProvider())
                .build();
        return  manager;
    }

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return Features.class;
    }

    @Override
    public StateRepository getStateRepository() {
        return customStateRepository;
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    }

}