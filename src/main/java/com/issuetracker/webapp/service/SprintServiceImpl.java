package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.repository.ProjectRepository;
import com.issuetracker.webapp.repository.SprintRepository;
import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.repository.model.Sprint;
import com.issuetracker.webapp.service.converter.ServiceDTOConverter;
import com.issuetracker.webapp.service.converter.SprintRequestConverter;
import com.issuetracker.webapp.service.converter.SprintResponseConverter;
import com.issuetracker.webapp.service.dto.request.sprint.SprintRequest;
import com.issuetracker.webapp.service.dto.response.sprint.SprintResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final ServiceDTOConverter<SprintRequest, Sprint> serviceSprintRequestConverter;
    private final ServiceDTOConverter<Sprint, SprintResponse> serviceSprintResponseConverter;

    public SprintServiceImpl(final SprintRepository sprintRepository,
                             final ProjectRepository projectRepository,
                             final SprintRequestConverter serviceSprintRequestConverter,
                             final SprintResponseConverter serviceSprintResponseConverter) {
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
        this.serviceSprintRequestConverter = serviceSprintRequestConverter;
        this.serviceSprintResponseConverter = serviceSprintResponseConverter;
    }

    @Override
    public SprintResponse createSprint(SprintRequest sprintRequest) {
        final Long projectId = sprintRequest.getProjectId();
        final Optional<Project> project = projectRepository.findById(projectId);

        project.orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " doesn't exists"));

        final Sprint sprint = serviceSprintRequestConverter.convert(sprintRequest);
        sprint.setProject(project.get());

        final Sprint savedSprint = sprintRepository.save(sprint);
        final SprintResponse sprintResponse = serviceSprintResponseConverter.convert(savedSprint);
        return sprintResponse;
    }
}
