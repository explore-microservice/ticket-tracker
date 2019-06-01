package com.issuetracker.webapp.service.dto.response.projectpage;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public class ProjectResponse {

    private final String name;
    private final String description;
    private final OffsetDateTime creationDate;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;
    private final List<Sprint> sprints;

    private ProjectResponse(Builder builder) {
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        startDate = builder.startDate;
        endDate = builder.endDate;
        sprints = builder.sprints;
    }

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

    public List<Sprint> getSprints() {
        return sprints;
    }

    public static final class Builder {
        private String name;
        private String description;
        private OffsetDateTime creationDate;
        private OffsetDateTime startDate;
        private OffsetDateTime endDate;
        private List<Sprint> sprints;

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

        public Builder withSprints(List<Sprint> val) {
            sprints = val;
            return this;
        }

        public ProjectResponse build() {
            return new ProjectResponse(this);
        }
    }
}
