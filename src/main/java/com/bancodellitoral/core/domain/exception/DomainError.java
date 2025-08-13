package com.bancodellitoral.core.domain.exception;

import lombok.Getter;

@Getter
public abstract class DomainError extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public DomainError(String errorCode, String errorMessage) {
        super(errorMessage);

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}