package com.issuetracker.webapp.service.converter;

import com.issuetracker.webapp.repository.model.Sprint;
import com.issuetracker.webapp.service.dto.response.sprint.SprintResponse;
import org.springframework.stereotype.Component;

@Component("serviceSprintResponseConverter")
public class SprintResponseConverter implements ServiceDTOConverter<Sprint, SprintResponse> {

    @Override
    public SprintResponse convert(Sprint input) {
        return new SprintResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withCreationDate(input.getCreationDate())
                .withStartDate(input.getStartDate())
                .withEndDate(input.getEndDate())
                .withProjectName(input.getProject().getName())
                .build();
    }
}
