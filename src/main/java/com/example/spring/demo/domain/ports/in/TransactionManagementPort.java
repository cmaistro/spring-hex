package com.example.spring.demo.domain.ports.in;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import org.springframework.data.domain.Page;

public interface TransactionManagementPort {
    PageableResponseDTO<TransactionSummaryDTO> findByFilters(FindTransactionSummaryRequest request, Integer offset, Integer size);
}
