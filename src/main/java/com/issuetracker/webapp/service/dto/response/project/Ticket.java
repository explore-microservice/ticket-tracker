package com.issuetracker.webapp.service.dto.response.project;

import java.util.Objects;

public class Ticket {

    private final String name;
    private final String description;
    private final Type type;
    private final Status status;
    private final String assignee;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String getAssignee() {
        return assignee;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(name, ticket.name) &&
                Objects.equals(description, ticket.description) &&
                type == ticket.type &&
                status == ticket.status &&
                Objects.equals(assignee, ticket.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, status, assignee);
    }

    private Ticket(Builder builder) {
        name = builder.name;
        description = builder.description;
        type = builder.type;
        status = builder.status;
        assignee = builder.assignee;
    }


    public static final class Builder {
        private String name;
        private String description;
        private Type type;
        private Status status;
        private String assignee;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withType(Type val) {
            type = val;
            return this;
        }

        public Builder withStatus(Status val) {
            status = val;
            return this;
        }

        public Builder withAssignee(String val) {
            assignee = val;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
