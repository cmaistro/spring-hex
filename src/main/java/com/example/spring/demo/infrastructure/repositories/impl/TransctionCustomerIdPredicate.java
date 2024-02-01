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
public class TransctionCustomerIdPredicate implements TransactionSummaryPredicateCreator {

    Logger logger = LoggerFactory.getLogger(TransctionCustomerIdPredicate.class);
    @Override
    public Predicate createPredicate(CriteriaBuilder cb, Root<Transaction> root, FindTransactionSummaryRequest request) {
        if (request.getCustomerIds() != null && !request.getCustomerIds().isEmpty()) {
            logger.info("request.getCustomerIds(): " + request.getCustomerIds());
            return cb.and(root.get("customerId").in(request.getCustomerIds()));
        }
        logger.info("request.getCustomerIds(): empty");
        return null;
    }
}
