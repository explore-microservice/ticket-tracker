package com.issuetracker.webapp.service.converter;

import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import org.springframework.stereotype.Component;

@Component
public class SProjectRequestConverter {

    public Project convert(final ProjectRequest projectRequest){
        return new Project.Builder()
                .withName(projectRequest.getName())
                .withDescription(projectRequest.getDescription())
                .withStartDate(projectRequest.getStartDate())
                .withEndDate(projectRequest.getEndDate())
                .build();
    }
}
