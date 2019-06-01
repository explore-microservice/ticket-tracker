package com.issuetracker.webapp.exceptions;

public class TicketStatusCannotBeEmptyException extends RuntimeException {

    public TicketStatusCannotBeEmptyException(String message) {
        super(message);
    }
}
