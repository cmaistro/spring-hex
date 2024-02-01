package com.example.spring.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FindTransactionSummaryRequest {
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate endDate;
    List<String> customerIds;
    List<String> terminalIds;
    List<Integer> bins;
    List<String> entryModes;

}
