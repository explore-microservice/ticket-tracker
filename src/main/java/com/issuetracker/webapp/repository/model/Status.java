package com.issuetracker.webapp.repository.model;

public enum Status {

    TODO("todo"),
    IN_PROGRESS("in-progress"),
    BLOCKED("blocked"),
    DONE("done"),
    ;

    private final String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
