package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;
import com.issuetracker.webapp.pojo.Sprint;
import com.issuetracker.webapp.pojo.Ticket;
import com.issuetracker.webapp.repository.ProjectRepository;
import com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse;
import com.issuetracker.webapp.service.dto.response.projectpage.Status;
import com.issuetracker.webapp.service.dto.response.projectpage.Type;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponse provideProjectPage(final Long id) throws ProjectNotFoundException {
        final Optional<Project> optionalProject = projectRepository.findById(id);
        optionalProject.orElseThrow(() -> new ProjectNotFoundException("Project with id: " + id + " is not found"));

        final ProjectResponse projectResponse = convertRepositoryToServiceLayer(optionalProject.get());
        return projectResponse;
    }

    private Map<Status, List<com.issuetracker.webapp.service.dto.response.projectpage.Ticket>> ticketConverter(final Set<Ticket> tickets){
        return tickets.stream().map(ticket -> new com.issuetracker.webapp.service.dto.response.projectpage.Ticket.Builder()
                .withName(ticket.getName())
                .withDescription(ticket.getDescription())
                .withType(Type.valueOf(ticket.getType().name()))
                .withAssignee(ticket.getAssignee().getUsername())
                .build())
            .collect(Collectors.groupingBy(com.issuetracker.webapp.service.dto.response.projectpage.Ticket::getStatus, HashMap::new, Collectors.toUnmodifiableList()));
    }

    private List<com.issuetracker.webapp.service.dto.response.projectpage.Sprint> sprintConverter(final Set<Sprint> sprints){
        return sprints.stream().map(sprint -> new com.issuetracker.webapp.service.dto.response.projectpage.Sprint.Builder()
                .withName(sprint.getName())
                .withDescription(sprint.getDescription())
                .withStartDate(sprint.getStartDate())
                .withEndDate(sprint.getEndDate())
                .withTickets(ticketConverter(sprint.getTickets()))
                .build())
            .collect(Collectors.toList());
    }

    private ProjectResponse convertRepositoryToServiceLayer(final Project project){
        return new ProjectResponse.Builder()
                .withName(project.getName())
                .withDescription(project.getDescription())
                .withCreationDate(project.getCreationDate())
                .withStartDate(project.getStartDate())
                .withEndDate(project.getEndDate())
                .withSprints(sprintConverter(project.getSprints()))
                .build();
    }
}
