package com.issuetracker.webapp.controller.converter.response.projectpage;

import com.issuetracker.webapp.controller.dto.response.projectpage.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProjectResponseConverter {

    public ProjectResponse convert(com.issuetracker.webapp.service.dto.response.projectpage.ProjectResponse projectResponse){
        return new ProjectResponse.Builder()
                .withName(projectResponse.getName())
                .withDescription(projectResponse.getDescription())
                .withStartDate(projectResponse.getStartDate())
                .withEndDate(projectResponse.getEndDate())
                .withCreationDate(projectResponse.getCreationDate())
                .withSprints(sprintConverter(projectResponse.getSprints()))
                .build();
    }

    private Map<Status, List<Ticket>> ticketConverter(
            final Map<com.issuetracker.webapp.service.dto.response.projectpage.Status,
                    List<com.issuetracker.webapp.service.dto.response.projectpage.Ticket>> tickets){

        return tickets.entrySet().stream().collect(Collectors.toUnmodifiableMap(
                k -> Status.valueOf(k.getKey().name()),
                v -> v.getValue().stream()
                        .map(ticket -> new Ticket.Builder()
                                .withName(ticket.getName())
                                .withDescription(ticket.getDescription())
                                .withAssignee(ticket.getAssignee())
                                .withType(Type.valueOf(ticket.getType().name()))
                                .withStatus(Status.valueOf(ticket.getStatus().name()))
                                .build())
                        .collect(Collectors.toUnmodifiableList())
        ));
    }

    private List<Sprint> sprintConverter(final List<com.issuetracker.webapp.service.dto.response.projectpage.Sprint> sprints){
        return sprints.stream().map(sprint -> new Sprint.Builder()
                .withName(sprint.getName())
                .withDescription(sprint.getDescription())
                .withStartDate(sprint.getStartDate())
                .withEndDate(sprint.getEndDate())
                .withTickets(ticketConverter(sprint.getTickets()))
                .build())
            .collect(Collectors.toList());
    }

}
