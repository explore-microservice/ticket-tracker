package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.controller.converter.CProjectRequestConverter;
import com.issuetracker.webapp.controller.converter.CProjectResponseConverter;
import com.issuetracker.webapp.controller.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.controller.dto.response.project.ProjectResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final CProjectResponseConverter cProjectResponseConverter;
    private final CProjectRequestConverter cProjectRequestConverter;

    public ProjectController(final ProjectService projectService,
                             final CProjectResponseConverter cProjectResponseConverter,
                             final CProjectRequestConverter cProjectRequestConverter) {
        this.projectService = projectService;
        this.cProjectResponseConverter = cProjectResponseConverter;
        this.cProjectRequestConverter = cProjectRequestConverter;
    }

    @GetMapping(value = "/projects/{id}")
    public ProjectResponse projectPage(final @PathVariable Long id) throws ProjectNotFoundException {
        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse = projectService.provideProjectPage(id);
        return cProjectResponseConverter.convert(projectResponse);
    }

    @PostMapping(value = "/projects")
    public ProjectResponse createProject(@RequestBody final ProjectRequest payload){
        final com.issuetracker.webapp.service.dto.request.project.ProjectRequest projectRequest = cProjectRequestConverter.convert(payload);

        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse =  projectService.createProject(projectRequest);
        return cProjectResponseConverter.convert(projectResponse);
    }

    @PutMapping(value = "/projects")
    public ProjectResponse updateProject(@RequestBody final ProjectRequest payload) throws ProjectNotFoundException{
        final com.issuetracker.webapp.service.dto.request.project.ProjectRequest projectRequest = cProjectRequestConverter.convert(payload);
        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse = projectService.updateProject(projectRequest);

        return cProjectResponseConverter.convert(projectResponse);
    }
}
