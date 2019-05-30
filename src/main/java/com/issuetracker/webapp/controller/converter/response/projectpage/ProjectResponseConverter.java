package com.issuetracker.webapp.controller.converter.response.projectpage;

import com.issuetracker.webapp.controller.dto.response.projectpage.ProjectResponse;
import com.issuetracker.webapp.controller.dto.response.projectpage.Sprint;
import com.issuetracker.webapp.controller.dto.response.projectpage.Ticket;
import com.issuetracker.webapp.controller.dto.response.projectpage.Type;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
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
                .withSprints()
    }

    private List<Ticket> ticketConverter(final List<com.issuetracker.webapp.service.dto.response.projectpage.Ticket> tickets){
        return tickets.stream().map(ticket -> new Ticket.Builder()
                .withName(ticket.getName())
                .withDescription(ticket.getDescription())
                .withType(Type.valueOf(ticket.getType().name()))
                .withAssignee(ticket.getAssignee())
                .build())
            .collect(Collectors.toList());
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
