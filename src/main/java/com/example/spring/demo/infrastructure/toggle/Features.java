package com.example.spring.demo.infrastructure.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;

public enum Features implements Feature {

    @EnabledByDefault
    @Label("Validador de CPF")
    CPF_VALIDATOR;
}



