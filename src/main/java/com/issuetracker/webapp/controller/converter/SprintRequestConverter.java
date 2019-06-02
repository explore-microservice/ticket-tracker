package com.issuetracker.webapp.controller.converter;

import com.issuetracker.webapp.controller.dto.request.sprint.SprintRequest;
import org.springframework.stereotype.Component;

@Component("controllerSprintRequestConverter")
public class SprintRequestConverter implements ControllerDTOConverter<SprintRequest, com.issuetracker.webapp.service.dto.request.sprint.SprintRequest> {

    @Override
    public com.issuetracker.webapp.service.dto.request.sprint.SprintRequest convert(SprintRequest input) {
        return new com.issuetracker.webapp.service.dto.request.sprint.SprintRequest.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withStartDate(input.getStartDate())
                .withEndDate(input.getEndDate())
                .withProjectId(input.getProjectId())
                .build();
    }
}
