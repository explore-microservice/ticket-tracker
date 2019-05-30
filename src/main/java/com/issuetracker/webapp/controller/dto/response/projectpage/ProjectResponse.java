package com.issuetracker.webapp.controller.dto.response.projectpage;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectResponse {

    private final String name;
    private final String description;
    private final LocalDateTime creationDate;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public static final class Builder {
        private String name;
        private String description;
        private LocalDateTime creationDate;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
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

        public Builder withCreationDate(LocalDateTime val) {
            creationDate = val;
            return this;
        }

        public Builder withStartDate(LocalDateTime val) {
            startDate = val;
            return this;
        }

        public Builder withEndDate(LocalDateTime val) {
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
