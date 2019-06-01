package com.issuetracker.webapp.service.dto.response.project;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Sprint {

    private final String name;
    private final String description;
    private final Instant startDate;
    private final Instant endDate;
    private final Map<Status, List<Ticket>> tickets;

    private Sprint(Builder builder) {
        name = builder.name;
        description = builder.description;
        startDate = builder.startDate;
        endDate = builder.endDate;
        tickets = builder.tickets;
    }

    public String getName() {
        return name;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Map<Status, List<Ticket>> getTickets() {
        return tickets;
    }

    public String getDescription() {
        return description;
    }

    public static final class Builder {
        private String name;
        private String description;
        private Instant startDate;
        private Instant endDate;
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

        public Builder withStartDate(Instant val) {
            startDate = val;
            return this;
        }

        public Builder withEndDate(Instant val) {
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
