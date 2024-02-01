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
public class TransactionEntryModePredicate implements TransactionSummaryPredicateCreator {

    Logger logger = LoggerFactory.getLogger(TransactionEntryModePredicate.class);
    @Override
    public Predicate createPredicate(CriteriaBuilder cb, Root<Transaction> root, FindTransactionSummaryRequest request) {
        if (request.getEntryModes() != null && !request.getEntryModes().isEmpty()) {

            logger.info("request.getEntryModes(): " + request.getEntryModes());
            return cb.and(root.get("entryMode").in(request.getEntryModes()));
        }
        logger.info("request.getEntryModes(): empty");
        return null;
    }
}
