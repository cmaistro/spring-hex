package com.example.spring.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PageableResponseDTO<T> {

    private final List<T> content;
    private final Integer offset;
    private final Integer limit;
    private final Boolean hasMore;

}
