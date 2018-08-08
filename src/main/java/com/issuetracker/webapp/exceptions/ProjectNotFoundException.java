package com.issuetracker.webapp.exceptions;

public class ProjectNotFoundException extends Exception {

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
