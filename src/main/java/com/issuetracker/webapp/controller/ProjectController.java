package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.controller.converter.CProjectRequestConverter;
import com.issuetracker.webapp.controller.converter.CProjectResponseConverter;
import com.issuetracker.webapp.controller.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.controller.dto.response.projectpage.ProjectResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final CProjectResponseConverter CProjectResponseConverter;
    private final CProjectRequestConverter CProjectRequestConverter;

    public ProjectController(final ProjectService projectService,
                             final CProjectResponseConverter CProjectResponseConverter,
                             final CProjectRequestConverter CProjectRequestConverter) {
        this.projectService = projectService;
        this.CProjectResponseConverter = CProjectResponseConverter;
        this.CProjectRequestConverter = CProjectRequestConverter;
    }

    @GetMapping(value = "/projects/{id}")
    public ProjectResponse projectPage(final @PathVariable Long id) throws ProjectNotFoundException {
        final com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse projectResponse = projectService.provideProjectPage(id);
        return CProjectResponseConverter.convert(projectResponse);
    }

    @PostMapping(value = "/projects")
    public ProjectResponse createProject(@RequestBody final ProjectRequest payload){
        final com.issuetracker.webapp.service.dto.request.project.ProjectRequest projectRequest = CProjectRequestConverter.convert(payload);

        final com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse projectResponse =  projectService.createProject(projectRequest);
        return CProjectResponseConverter.convert(projectResponse);
    }
}
