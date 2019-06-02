package com.issuetracker.webapp.service.converter;

public interface ServiceDTOConverter<T, R> {

    R convert(final T input);
}
