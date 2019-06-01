package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse;

public interface ProjectService {

    ProjectResponse provideProjectPage(final Long id) throws ProjectNotFoundException;
    ProjectResponse createProject(final ProjectRequest projectRequest);
}
