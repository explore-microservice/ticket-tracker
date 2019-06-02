package com.issuetracker.webapp.controller.converter;

public interface ControllerDTOConverter<T, R> {

    R convert(final T input);
}
