package com.issuetracker.webapp.service.dto.request.project;

import java.time.OffsetDateTime;

public class ProjectRequest {

    private final String name;
    private final String description;
    private final OffsetDateTime creationDate;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
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
        private OffsetDateTime creationDate;
        private OffsetDateTime startDate;
        private OffsetDateTime endDate;

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

        public Builder withCreationDate(OffsetDateTime val) {
            creationDate = val;
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

        public ProjectRequest build() {
            return new ProjectRequest(this);
        }
    }
}
