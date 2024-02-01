package com.example.spring.demo.infrastructure.repositories;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.model.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public interface TransactionSummaryPredicateCreator {

    Predicate createPredicate(CriteriaBuilder cb, Root<Transaction> root, FindTransactionSummaryRequest request);
}
