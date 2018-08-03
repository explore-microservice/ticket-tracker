package com.issuetracker.webapp.service;

import com.issuetracker.webapp.dao.ProjectRepository;
import com.issuetracker.webapp.pojo.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
