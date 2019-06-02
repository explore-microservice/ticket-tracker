package com.issuetracker.webapp.controller.converter;

import com.issuetracker.webapp.controller.dto.response.project.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("controllerProjectResponseConverter")
public class ProjectResponseConverter {

    public ProjectResponse convert(com.issuetracker.webapp.service.dto.response.project.ProjectResponse projectResponse){
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
            final Map<com.issuetracker.webapp.service.dto.response.project.Status,
                    List<com.issuetracker.webapp.service.dto.response.project.Ticket>> tickets){

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

    private List<Sprint> sprintConverter(final List<com.issuetracker.webapp.service.dto.response.project.Sprint> sprints){
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
