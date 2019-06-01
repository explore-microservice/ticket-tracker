package com.issuetracker.webapp.exceptions;

public class TicketTypeCannotBeEmptyException extends RuntimeException {

    public TicketTypeCannotBeEmptyException(String message) {
        super(message);
    }
}
