package com.issuetracker.webapp.exceptions.dto.response;

import org.springframework.http.HttpStatus;

public class StatusResponse {

    private final String message;
    private final HttpStatus status;

    public StatusResponse(String message, HttpStatus status) {
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
