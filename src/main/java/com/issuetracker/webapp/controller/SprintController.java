package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.controller.converter.ControllerDTOConverter;
import com.issuetracker.webapp.controller.converter.SprintRequestConverter;
import com.issuetracker.webapp.controller.converter.SprintResponseConverter;
import com.issuetracker.webapp.controller.dto.request.sprint.SprintRequest;
import com.issuetracker.webapp.controller.dto.response.sprint.SprintResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.service.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SprintController {

    private final SprintService sprintService;
    private final ControllerDTOConverter<SprintRequest, com.issuetracker.webapp.service.dto.request.sprint.SprintRequest> controllerSprintRequestConverter;
    private final ControllerDTOConverter<com.issuetracker.webapp.service.dto.response.sprint.SprintResponse, SprintResponse> controllerSprintResponseConverter;

    public SprintController(SprintService sprintService,
                            SprintRequestConverter controllerSprintRequestConverter,
                            SprintResponseConverter controllerSprintResponseConverter) {
        this.sprintService = sprintService;
        this.controllerSprintRequestConverter = controllerSprintRequestConverter;
        this.controllerSprintResponseConverter = controllerSprintResponseConverter;
    }

    @PostMapping(path = "/sprints")
    public ResponseEntity<SprintResponse> createSpring(@RequestBody final SprintRequest payload) throws ProjectNotFoundException {
        final com.issuetracker.webapp.service.dto.request.sprint.SprintRequest sprintRequest = controllerSprintRequestConverter.convert(payload);

        final com.issuetracker.webapp.service.dto.response.sprint.SprintResponse sprintResponse = sprintService.createSprint(sprintRequest);
        return new ResponseEntity<>(controllerSprintResponseConverter.convert(sprintResponse), HttpStatus.CREATED);
    }
}
