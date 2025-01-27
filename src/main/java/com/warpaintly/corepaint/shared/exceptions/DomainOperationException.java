package com.warpaintly.corepaint.shared.exceptions;

public abstract class DomainOperationException extends RuntimeException {

    private final String message;

    protected DomainOperationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public abstract String getErrorCode();
}
