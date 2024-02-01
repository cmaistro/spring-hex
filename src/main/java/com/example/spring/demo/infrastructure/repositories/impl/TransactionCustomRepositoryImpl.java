package com.example.spring.demo.infrastructure.repositories.impl;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import com.example.spring.demo.domain.model.Transaction;
import com.example.spring.demo.infrastructure.repositories.TransactionCustomRepository;
import com.example.spring.demo.infrastructure.repositories.TransactionSummaryPredicateCreator;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Repository
@RequiredArgsConstructor
public class TransactionCustomRepositoryImpl implements TransactionCustomRepository {

    Logger logger = LoggerFactory.getLogger(TransactionCustomRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    private final List<TransactionSummaryPredicateCreator> predicateCreators;

      @Override
    public PageableResponseDTO<TransactionSummaryDTO> findByFilters(FindTransactionSummaryRequest request, Integer offset, Integer size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransactionSummaryDTO> cq = cb.createQuery(TransactionSummaryDTO.class);
        Root<Transaction> root = cq.from(Transaction.class);
        cq.multiselect(root.get("customerId"),
                root.get("entryMode"),
                root.get("bin"),
                cb.sum(root.get("amount")).as(BigDecimal.class).alias("amount"));

        cq.where(cb.and(predicateCreators
                .stream()
                .map(predicateCreator -> predicateCreator.createPredicate(cb, root, request))
                .filter(Objects::nonNull)
                .toArray(Predicate[]::new)));

        cq.groupBy(root.get("customerId"), root.get("entryMode"), root.get("bin"));

        cq.orderBy(cb.asc(root.get("customerId")), cb.asc(root.get("entryMode")), cb.asc(root.get("bin")));

        TypedQuery<TransactionSummaryDTO> tq = em.createQuery(cq);
        tq.setFirstResult(offset);
        tq.setMaxResults(size + 1);

        return new PageableResponseDTO<TransactionSummaryDTO>(tq.getResultList().subList(0, size), offset, size, tq.getResultList().size() > size);

    }
}
