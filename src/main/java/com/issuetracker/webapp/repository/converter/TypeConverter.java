package com.issuetracker.webapp.repository.converter;

import com.issuetracker.webapp.exceptions.TicketTypeCannotBeEmptyException;
import com.issuetracker.webapp.repository.model.Type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(final Type type) {
        if(type == null){
            throw new TicketTypeCannotBeEmptyException("Type of a ticket cannot be null");
        }
        return type.getCode();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        return Stream.of(Type.values())
                .filter(type -> type.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
