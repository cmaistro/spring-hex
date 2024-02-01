package com.example.spring.demo.infrastructure.repositories;

import com.example.spring.demo.domain.model.Transaction;
import com.example.spring.demo.domain.ports.out.TransactionDatasourcePort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String>, TransactionCustomRepository, TransactionDatasourcePort {


}
