package com.issuetracker.webapp.controller.converter;

import com.issuetracker.webapp.controller.dto.response.sprint.SprintResponse;
import org.springframework.stereotype.Component;

@Component("controllerSprintResponseConverter")
public class SprintResponseConverter implements ControllerDTOConverter<com.issuetracker.webapp.service.dto.response.sprint.SprintResponse, SprintResponse>{

    @Override
    public SprintResponse convert(com.issuetracker.webapp.service.dto.response.sprint.SprintResponse input) {
        return new SprintResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withCreationDate(input.getCreationDate())
                .withStartDate(input.getStartDate())
                .withEndDate(input.getEndDate())
                .withProjectName(input.getProjectName())
                .build();
    }
}
