package com.example.spring.demo.domain.ports.out;

import com.example.spring.demo.infrastructure.toggle.Features;

public interface FeatureTogglePort {
    boolean isFeatureActive(Features feature);
}
