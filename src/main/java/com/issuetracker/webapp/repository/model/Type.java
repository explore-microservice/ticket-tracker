package com.issuetracker.webapp.repository.model;

public enum Type {

    STORY("story"),
    BUG("bug"),
    SPIKE("spike"),
    ;

    private final String code;

    Type(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
