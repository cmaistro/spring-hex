package com.example.spring.demo.application.controllers.exception;

import com.example.spring.demo.domain.exceptions.InvalidRequestDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    @ExceptionHandler(value = { InvalidRequestDataException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        ExceptionResponseDTO response =  new ExceptionResponseDTO("ERR0001", ex.getMessage());
        logger.error(String.format("Error when executing %s", request.getDescription(true)),  ex);
        logger.info("Error returned to caller: " + response);
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
