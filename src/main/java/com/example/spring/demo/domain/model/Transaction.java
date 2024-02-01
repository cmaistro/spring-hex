package com.example.spring.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "post_ts")
    private LocalDate date;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "bin")
    private Integer bin;

    @Column(name = "terminal_id")
    private String terminalId;

    @Column(name = "amt")
    private BigDecimal amount;

    @Column(name = "entry_mode")
    private String entryMode;

    @Column(name = "fraud")
    private Integer fraud;

    @Column(name = "fraud_scenario")
    private Integer fraudScenario;

    public Transaction(String customerId, String entryMode, int bin, BigDecimal amount) {
        this.customerId = customerId;
        this.entryMode = entryMode;
        this.bin = bin;
        this.amount = amount;
    }

}
