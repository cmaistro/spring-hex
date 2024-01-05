package com.example.spring.demo.infrastructure.toggle.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureToggleRepository extends JpaRepository<FeatureToggleEntity, String> {
}
