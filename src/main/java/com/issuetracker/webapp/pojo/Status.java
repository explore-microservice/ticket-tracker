package com.issuetracker.webapp.pojo;

import org.springframework.http.HttpStatus;

public  class Status {

    private String message;
    private HttpStatus httpStatus;

    protected Status() {
    }

    public Status(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
