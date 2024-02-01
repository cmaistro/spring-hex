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
public class TransactionBinPredicate implements TransactionSummaryPredicateCreator {

    Logger logger = LoggerFactory.getLogger(TransactionBinPredicate.class);
    @Override
    public Predicate createPredicate(CriteriaBuilder cb, Root<Transaction> root, FindTransactionSummaryRequest request) {
        if (request.getBins() != null && !request.getBins().isEmpty()) {

            logger.info("request.getBins(): " + request.getBins());

            return cb.and(root.get("bin").in(request.getBins()));
        }

        logger.info("request.getBins(): empty");

        return null;
    }
}
