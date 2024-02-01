package com.example.spring.demo.domain.ports.out;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import org.springframework.data.domain.Page;

public interface TransactionDatasourcePort {

    PageableResponseDTO<TransactionSummaryDTO> findByFilters(FindTransactionSummaryRequest request, Integer page, Integer size);

}
