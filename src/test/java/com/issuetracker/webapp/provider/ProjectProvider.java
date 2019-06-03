package com.issuetracker.webapp.provider.service.project;

import com.issuetracker.webapp.provider.SprintProvider;
import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.issuetracker.webapp.provider.SprintProvider.aRepositorySprintWithTickets;

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

    public static Project aRepositoryProject(){
        return new Project.Builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();
    }

    public static ProjectResponse aServiceProjectResponseWithoutSprints(){
        return new ProjectResponse.Builder()
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withSprints(Collections.emptyList())
                .build();
    }

    public static Project aRepositoryProjectWithSprints(){
        return new Project.Builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withSprints(Collections.unmodifiableSet(Set.of(aRepositorySprintWithTickets())))
                .build();
    }

    public static ProjectResponse aServiceProjectResponseWithSprints(){
        return new ProjectResponse.Builder()
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withSprints(Collections.unmodifiableList(List.of(SprintProvider.aServiceSprintWithTickets())))
                .build();
    }
}
