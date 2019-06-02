package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;

public interface ProjectService {

    ProjectResponse getProject(final Long id) throws ProjectNotFoundException;
    ProjectResponse createProject(final ProjectRequest projectRequest);
    ProjectResponse updateProject(final Long id, final ProjectRequest projectRequest) throws ProjectNotFoundException;

    void deleteProject(final Long id);
}
