package com.issuetracker.webapp.service.dto.request.project;

import java.time.Instant;
import java.util.Optional;

public class ProjectRequest {

    private final String name;
    private final String description;
    private final Instant creationDate;
    private final Instant startDate;
    private final Instant endDate;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<Instant> getCreationDate() {
        return Optional.ofNullable(creationDate);
    }

    public Optional<Instant> getStartDate() {
        return Optional.ofNullable(startDate);
    }

    public Optional<Instant> getEndDate() {
        return Optional.ofNullable(endDate);
    }

    private ProjectRequest(Builder builder) {
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }


    public static final class Builder {
        private String name;
        private String description;
        private Instant creationDate;
        private Instant startDate;
        private Instant endDate;

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

        public Builder withCreationDate(Instant val) {
            creationDate = val;
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

        public ProjectRequest build() {
            return new ProjectRequest(this);
        }
    }
}
