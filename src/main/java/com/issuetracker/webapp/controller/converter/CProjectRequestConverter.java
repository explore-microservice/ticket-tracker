package com.issuetracker.webapp.controller.converter;

import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class CProjectRequestConverter {

    public ProjectRequest convert(com.issuetracker.webapp.controller.dto.request.project.ProjectRequest projectRequest){
        return new ProjectRequest.Builder()
                .withName(projectRequest.getName())
                .withDescription(projectRequest.getDescription())
                .withStartDate(projectRequest.getStartDate())
                .withEndDate(projectRequest.getEndDate())
                .withCreationDate(OffsetDateTime.now())
                .build();
    }
}
