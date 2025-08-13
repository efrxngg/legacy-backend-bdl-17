package com.bancodellitoral.core.infrastructure.rest.exception.handler;

import com.bancodellitoral.core.domain.exception.CustomerAlreadyExists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerAlreadyExists.class})
    public ResponseEntity<Object> handleException(CustomerAlreadyExists ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
