package com.issuetracker.webapp.exceptionhandlers;

import org.springframework.http.HttpStatus;

public class Status {

    private final String message;
    private final HttpStatus status;

    public Status(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
