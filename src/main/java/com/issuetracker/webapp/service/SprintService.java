package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.dto.request.sprint.SprintRequest;
import com.issuetracker.webapp.service.dto.response.sprint.SprintResponse;

public interface SprintService {

    SprintResponse createSprint(SprintRequest sprintRequest) throws ProjectNotFoundException;
}
