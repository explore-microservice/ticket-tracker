package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.repository.ProjectRepository;
import com.issuetracker.webapp.service.converter.SProjectRequestConverter;
import com.issuetracker.webapp.service.converter.SProjectResponseConverter;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;
    private final SProjectResponseConverter sProjectResponseConverter;
    private final SProjectRequestConverter sProjectRequestConverter;

    public ProjectServiceImpl(
            final ProjectRepository projectRepository,
            final SProjectResponseConverter sProjectResponseConverter,
            final SProjectRequestConverter sProjectRequestConverter) {
        this.projectRepository = projectRepository;
        this.sProjectResponseConverter = sProjectResponseConverter;
        this.sProjectRequestConverter = sProjectRequestConverter;
    }

    @Override
    public ProjectResponse provideProjectPage(final Long id) throws ProjectNotFoundException {
        final Optional<Project> optionalProject = projectRepository.findById(id);
        final Project project = optionalProject.orElseThrow(() -> new ProjectNotFoundException("Project with id: " + id + " is not found"));

        final ProjectResponse projectResponse = sProjectResponseConverter.convert(project);
        return projectResponse;
    }

    @Override
    public ProjectResponse createProject(final ProjectRequest projectRequest) {
        final Project projectInput = sProjectRequestConverter.convert(projectRequest);
        projectInput.setCreationDate(Instant.now());

        final Project projectOutput = projectRepository.save(projectInput);

        final ProjectResponse projectResponse = sProjectResponseConverter.convert(projectOutput);
        return projectResponse;
    }

    @Override
    public ProjectResponse updateProject(final ProjectRequest projectRequest) throws ProjectNotFoundException{
        final Optional<Project> optionalProject = projectRepository.findById(projectRequest.getId());

        final Project project = optionalProject.orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectRequest.getId() + " doesn't exists."));

        projectRequest.getName().ifPresent(project::setName);
        projectRequest.getDescription().ifPresent(project::setDescription);
        projectRequest.getStartDate().ifPresent(project::setStartDate);
        projectRequest.getEndDate().ifPresent(project::setEndDate);

        final Project projectOutput = projectRepository.save(project);

        final ProjectResponse projectResponse = sProjectResponseConverter.convert(projectOutput);
        return projectResponse;
    }

    @Override
    public void deleteProject(final Long id) {
        projectRepository.deleteById(id);
    }
}
