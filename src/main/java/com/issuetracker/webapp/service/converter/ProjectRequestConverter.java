package com.issuetracker.webapp.service.converter;

import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceProjectRequestConverter")
public class ProjectRequestConverter {

    public Project convert(final ProjectRequest projectRequest){
        return new Project.Builder()
                .withName(projectRequest.getName().orElse(null))
                .withDescription(projectRequest.getDescription().orElse(null))
                .withStartDate(projectRequest.getStartDate().orElse(null))
                .withEndDate(projectRequest.getEndDate().orElse(null))
                .build();
    }
}
