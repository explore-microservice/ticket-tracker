package com.issuetracker.webapp.controller.dto.response.projectpage;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Sprint {

    private final String name;
    private final String description;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;
    private final Map<Status, List<Ticket>> tickets;

    public String getName() {
        return name;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public Map<Status, List<Ticket>> getTickets() {
        return tickets;
    }

    public String getDescription() {
        return description;
    }

    private Sprint(Builder builder) {
        name = builder.name;
        description = builder.description;
        startDate = builder.startDate;
        endDate = builder.endDate;
        tickets = builder.tickets;
    }


    public static final class Builder {
        private String name;
        private String description;
        private OffsetDateTime startDate;
        private OffsetDateTime endDate;
        private Map<Status, List<Ticket>> tickets;

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

        public Builder withStartDate(OffsetDateTime val) {
            startDate = val;
            return this;
        }

        public Builder withEndDate(OffsetDateTime val) {
            endDate = val;
            return this;
        }

        public Builder withTickets(Map<Status, List<Ticket>> val) {
            tickets = val;
            return this;
        }

        public Sprint build() {
            return new Sprint(this);
        }
    }
}
