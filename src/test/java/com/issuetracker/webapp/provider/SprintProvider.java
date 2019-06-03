package com.issuetracker.webapp.provider;

import com.issuetracker.webapp.repository.model.Sprint;
import com.issuetracker.webapp.service.dto.response.project.Status;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.issuetracker.webapp.provider.TicketProvider.aServiceTicket;
import static com.issuetracker.webapp.provider.TicketProvider.aTicket;

public class SprintProvider {

    public static Long id = 1L;
    public static String name = "sprint";
    public static String description = "description";
    public static Instant creationDate = Instant.now();
    public static Instant startDate = Instant.MIN;
    public static Instant endDate = Instant.MAX;

    public static Sprint aRepositorySprintWithTickets(){
        return new Sprint.Builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withProject(ProjectProvider.aRepositoryProject())
                .withTickets(Collections.unmodifiableSet(Set.of(aTicket())))
                .build();
    }

    public static com.issuetracker.webapp.service.dto.response.project.Sprint aServiceSprintWithTickets(){
        return new com.issuetracker.webapp.service.dto.response.project.Sprint.Builder()
                .withName(name)
                .withDescription(description)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withTickets(Collections.unmodifiableMap(Map.of(
                                Status.TODO,
                                Collections.unmodifiableList(List.of(aServiceTicket())))))
                .build();
    }
}
