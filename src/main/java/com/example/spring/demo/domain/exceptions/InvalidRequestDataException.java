package com.example.spring.demo.domain.exceptions;

public class InvalidRequestDataException extends RuntimeException{

    public InvalidRequestDataException(String errorMessage) {
        super (errorMessage);
    }
}
