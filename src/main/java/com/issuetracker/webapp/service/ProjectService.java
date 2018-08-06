package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;

public interface ProjectService {

    Project getProjectById(Long id) throws ProjectNotFoundException;
}
