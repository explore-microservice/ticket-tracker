package com.issuetracker.webapp.service.converter;

import com.issuetracker.webapp.repository.model.Sprint;
import com.issuetracker.webapp.service.dto.request.sprint.SprintRequest;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component("serviceSprintRequestConverter")
public class SprintRequestConverter implements ServiceDTOConverter<SprintRequest, Sprint> {

    @Override
    public Sprint convert(SprintRequest input) {
        return new Sprint.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withCreationDate(Instant.now())
                .withStartDate(input.getStartDate())
                .withEndDate(input.getEndDate())
                .build();
    }
}
