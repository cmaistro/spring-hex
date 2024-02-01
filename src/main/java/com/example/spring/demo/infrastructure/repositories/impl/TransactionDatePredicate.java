package com.example.spring.demo.infrastructure.repositories.impl;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.model.Transaction;
import com.example.spring.demo.infrastructure.repositories.TransactionSummaryPredicateCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
@Component
public class TransactionDatePredicate implements TransactionSummaryPredicateCreator {
    Logger logger = LoggerFactory.getLogger(TransactionDatePredicate.class);
    @Override
    public Predicate createPredicate(CriteriaBuilder cb, Root<Transaction> root, FindTransactionSummaryRequest request) {

        logger.info("request.getStartDate(): " + request.getStartDate());
        logger.info("request.getEndDate(): " + request.getEndDate());
        return cb.and(cb.between(root.get("date"), request.getStartDate(), request.getEndDate()));

    }
}
