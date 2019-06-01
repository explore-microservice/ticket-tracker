package com.issuetracker.webapp.repository.converter;

import com.issuetracker.webapp.exceptions.TicketStatusCannotBeEmptyException;
import com.issuetracker.webapp.repository.model.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(final Status status) {
        if(status == null){
            throw new TicketStatusCannotBeEmptyException("Ticket status cannot be null");
        }

        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(final String dbData) {
        if(dbData == null){
            return null;
        }
        return Stream.of(Status.values())
                .filter(status -> status.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
