package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.repository.ProjectRepository;
import com.issuetracker.webapp.service.converter.SProjectRequestConverter;
import com.issuetracker.webapp.service.converter.SProjectResponseConverter;
import com.issuetracker.webapp.service.dto.request.project.ProjectRequest;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final SProjectResponseConverter SProjectResponseConverter;
    private final SProjectRequestConverter SProjectRequestConverter;

    public ProjectServiceImpl(
            final ProjectRepository projectRepository,
            final SProjectResponseConverter SProjectResponseConverter,
            final SProjectRequestConverter SProjectRequestConverter) {
        this.projectRepository = projectRepository;
        this.SProjectResponseConverter = SProjectResponseConverter;
        this.SProjectRequestConverter = SProjectRequestConverter;
    }

    @Override
    public ProjectResponse provideProjectPage(final Long id) throws ProjectNotFoundException {
        final Optional<Project> optionalProject = projectRepository.findById(id);
        optionalProject.orElseThrow(() -> new ProjectNotFoundException("Project with id: " + id + " is not found"));

        final ProjectResponse projectResponse = SProjectResponseConverter.convert(optionalProject.get());
        return projectResponse;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        final Project projectInput = SProjectRequestConverter.convert(projectRequest);
        projectInput.setCreationDate(Instant.now());

        final Project projectOutput = projectRepository.save(projectInput);

        final ProjectResponse projectResponse = SProjectResponseConverter.convert(projectOutput);
        return projectResponse;
    }
}
