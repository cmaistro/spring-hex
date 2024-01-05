package com.example.spring.demo.infrastructure.toggle.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "togglz")
@Getter
@Setter
public class FeatureToggleEntity {
    @Id
    private String featureName;
    private boolean enabled;

}
