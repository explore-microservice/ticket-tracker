package com.issuetracker.webapp.provider;

import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;

import java.time.Instant;

public class ProjectProvider {

    public static Long id = 1L;
    public static String name = "project";
    public static String description = "description";
    public static Instant creationDate = Instant.now();
    public static Instant startDate = Instant.MIN;
    public static Instant endDate = Instant.MAX;

    public static Project aRepositoryProjectWithName(){
        return new Project.Builder().withName(name).build();
    }

    public static Project aRepositoryProjectWithCreationDate(){
        return new Project.Builder().withCreationDate(Instant.now()).build();
    }

    public static ProjectResponse emptyServiceProjectResponse(){
        return new ProjectResponse.Builder().build();
    }
}
