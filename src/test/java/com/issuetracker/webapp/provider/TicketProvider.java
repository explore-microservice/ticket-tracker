package com.issuetracker.webapp.provider;

import com.issuetracker.webapp.repository.model.Status;
import com.issuetracker.webapp.repository.model.Ticket;
import com.issuetracker.webapp.repository.model.Type;
import com.issuetracker.webapp.repository.model.User;

import java.time.Instant;

import static com.issuetracker.webapp.provider.UserProvider.aUser;

public class TicketProvider {

    public static Long id = 1L;
    public static String name = "project";
    public static String description = "description";
    public static Instant creationDate = Instant.now();
    public static Type type = Type.STORY;
    public static Status status = Status.TODO;
    public static User creator = aUser();
    public static User assignee = aUser();

    public static Ticket aTicket(){
        return new Ticket.Builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withCreationDate(creationDate)
                .withType(type)
                .withStatus(status)
                .withCreator(creator)
                .withAssignee(assignee)
                .build();
    }

    public static com.issuetracker.webapp.service.dto.response.project.Ticket aServiceTicket(){
        return new com.issuetracker.webapp.service.dto.response.project.Ticket.Builder()
                .withName(name)
                .withDescription(description)
                .withAssignee(assignee.getUsername())
                .withType(com.issuetracker.webapp.service.dto.response.project.Type.STORY)
                .withStatus(com.issuetracker.webapp.service.dto.response.project.Status.TODO)
                .build();
    }

}
