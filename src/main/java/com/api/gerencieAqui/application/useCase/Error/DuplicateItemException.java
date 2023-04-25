package com.api.gerencieAqui.application.useCase.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class DuplicateItemException extends RuntimeException {
    private final HttpStatus httpStatus = HttpStatus.CONFLICT;
    private final String errorMessage;

    public DuplicateItemException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public ResponseEntity<Object> returnResponseEntity(){
        return ResponseEntity.status(this.httpStatus).body(this.errorMessage);
    }
}

