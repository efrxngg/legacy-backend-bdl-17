package com.bancodellitoral.core.domain.exception;

public class CustomerAlreadyExists extends DomainError {

    private static final String ERROR_CODE = "100";
    private static final String ERROR_MESSAGE = "El cliente ya existe";

    public CustomerAlreadyExists() {
        super(ERROR_CODE, ERROR_MESSAGE);
    }

    public CustomerAlreadyExists(String errorMessage) {
        super(ERROR_CODE, errorMessage);
    }

}
