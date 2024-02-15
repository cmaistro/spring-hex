package com.example.spring.demo.application.controllers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ExceptionResponseDTO {

    private String errorCode;
    private String errorMessage;
}
