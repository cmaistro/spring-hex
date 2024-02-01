package com.example.spring.demo.domain.services;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import com.example.spring.demo.domain.ports.in.TransactionManagementPort;
import com.example.spring.demo.domain.ports.out.TransactionDatasourcePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionManagementPort {

    private final TransactionDatasourcePort transactionDatasource;

    public PageableResponseDTO<TransactionSummaryDTO> findByFilters(FindTransactionSummaryRequest request, Integer offset, Integer size) {
        return transactionDatasource.findByFilters(request, offset, size);
    }

}
