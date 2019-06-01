package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.controller.converter.response.projectpage.ProjectResponseConverter;
import com.issuetracker.webapp.controller.dto.response.projectpage.ProjectResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;
import com.issuetracker.webapp.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectResponseConverter projectResponseConverter;

    public ProjectController(final ProjectService projectService,
                             final ProjectResponseConverter projectResponseConverter) {
        this.projectService = projectService;
        this.projectResponseConverter = projectResponseConverter;
    }

    @GetMapping(value = "/project/{id}")
    public ProjectResponse projectPage(final @PathVariable Long id) throws ProjectNotFoundException {
        final com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse projectResponse = projectService.provideProjectPage(id);
        return projectResponseConverter.convert(projectResponse);
    }
}
