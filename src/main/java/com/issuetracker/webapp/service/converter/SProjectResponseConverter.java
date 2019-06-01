package com.issuetracker.webapp.service.converter;

import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.repository.model.Sprint;
import com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse;
import com.issuetracker.webapp.service.dto.response.projectpage.Status;
import com.issuetracker.webapp.service.dto.response.projectpage.Ticket;
import com.issuetracker.webapp.service.dto.response.projectpage.Type;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SProjectResponseConverter {

    private Map<Status, List<Ticket>> ticketConverter(final Set<com.issuetracker.webapp.repository.model.Ticket> tickets){
        return tickets.stream().map(ticket -> new com.issuetracker.webapp.service.dto.response.projectpage.Ticket.Builder()
                .withName(ticket.getName())
                .withDescription(ticket.getDescription())
                .withType(Type.valueOf(ticket.getType().name()))
                .withStatus(Status.valueOf(ticket.getStatus().name()))
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

    public ProjectResponse convert(final Project project){
        return new ProjectResponse.Builder()
                .withName(project.getName())
                .withDescription(project.getDescription())
                .withCreationDate(project.getCreationDate())
                .withStartDate(project.getStartDate())
                .withEndDate(project.getEndDate())
                .withSprints(sprintConverter(project.getSprints().orElse(Collections.emptySet())))
                .build();
    }
}
