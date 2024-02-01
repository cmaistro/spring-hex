package com.example.spring.demo.application.controllers;

import com.example.spring.demo.domain.dto.FindTransactionSummaryRequest;
import com.example.spring.demo.domain.dto.PageableResponseDTO;
import com.example.spring.demo.domain.dto.TransactionSummaryDTO;
import com.example.spring.demo.domain.ports.in.TransactionManagementPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionManagementPort transactionManagement;

    @PostMapping
    public ResponseEntity<PageableResponseDTO<TransactionSummaryDTO>> findByFilters(@RequestBody FindTransactionSummaryRequest request,
                                                                                    @RequestParam(defaultValue = "0") int offset,
                                                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(transactionManagement.findByFilters(request, offset, size));
    }

}
