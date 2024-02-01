package com.example.spring.demo.infrastructure.repositories;

import com.example.spring.demo.domain.model.Customer;
import com.example.spring.demo.domain.ports.out.CustomerDatasourcePort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CustomerDatasourcePort, JpaRepository<Customer, UUID> {
}
