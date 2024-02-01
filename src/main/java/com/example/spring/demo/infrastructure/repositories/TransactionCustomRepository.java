package com.example.spring.demo.infrastructure.repositories;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import org.springframework.data.domain.Page;

public interface TransactionCustomRepository {

    PageableResponseDTO<TransactionSummaryDTO> findByFilters(FindTransactionSummaryRequest request, Integer offset, Integer size);


}
