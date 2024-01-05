package com.example.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.security.RolesAllowed;

@SpringBootApplication
public class DemoApplication {
	@RolesAllowed("*")
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
