package com.example.spring.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class TransactionSummaryDTO {

    private String customerId;
    private String entryMode;
    private Integer bin;
    private BigDecimal totalAmount;
}
