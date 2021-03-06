package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.controller.converter.ControllerDTOConverter;
import com.issuetracker.webapp.controller.converter.ProjectRequestConverter;
import com.issuetracker.webapp.controller.converter.ProjectResponseConverter;
import com.issuetracker.webapp.controller.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.controller.dto.response.project.ProjectResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.exceptions.dto.response.StatusResponse;
import com.issuetracker.webapp.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(description = "Project related CRUD operations and information.")
public class ProjectController {

    private final ProjectService projectService;
    private final ControllerDTOConverter<com.issuetracker.webapp.service.dto.response.project.ProjectResponse, ProjectResponse> controllerProjectResponseConverter;
    private final ControllerDTOConverter<ProjectRequest, com.issuetracker.webapp.service.dto.request.project.ProjectRequest> controllerProjectRequestConverter;

    public ProjectController(final ProjectService projectService,
                             final ProjectResponseConverter controllerProjectResponseConverter,
                             final ProjectRequestConverter controllerProjectRequestConverter) {
        this.projectService = projectService;
        this.controllerProjectResponseConverter = controllerProjectResponseConverter;
        this.controllerProjectRequestConverter = controllerProjectRequestConverter;
    }

    @ApiOperation(value = "Get details about a particular project", response = ProjectResponse.class)
    @GetMapping(value = "/projects/{id}", produces = "application/json")
    public ProjectResponse projectPage(final @PathVariable Long id) {
        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse = projectService.getProject(id);
        return controllerProjectResponseConverter.convert(projectResponse);
    }

    @PostMapping(value = "/projects", produces = "application/json")
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody final ProjectRequest payload){
        final com.issuetracker.webapp.service.dto.request.project.ProjectRequest projectRequest = controllerProjectRequestConverter.convert(payload);

        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse =  projectService.createProject(projectRequest);
        return new ResponseEntity<>(controllerProjectResponseConverter.convert(projectResponse), HttpStatus.CREATED);
    }

    @PutMapping(value = "/projects/{id}", produces = "application/json")
    public ProjectResponse updateProject(@PathVariable final Long id, @RequestBody final ProjectRequest payload) {
        final com.issuetracker.webapp.service.dto.request.project.ProjectRequest projectRequest = controllerProjectRequestConverter.convert(payload);
        final com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse = projectService.updateProject(id, projectRequest);

        return controllerProjectResponseConverter.convert(projectResponse);
    }

//    @DeleteMapping(value = "/projects/{id}", produces = "application/json")
//    public StatusResponse deleteProject(final @PathVariable Long id) {
//        projectService.deleteProject(id);
//        return new StatusResponse("The project has been successfully deleted", HttpStatus.OK);
//    }
}
