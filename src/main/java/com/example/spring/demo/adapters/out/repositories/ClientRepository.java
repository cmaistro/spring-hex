package com.example.spring.demo.adapters.out.repositories;

import com.example.spring.demo.domain.model.Client;
import com.example.spring.demo.domain.ports.out.ClientRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends ClientRepositoryPort, JpaRepository<Client, UUID> {
}
