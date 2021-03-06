package com.issuetracker.webapp.service.dto.response.sprint;

import java.time.Instant;
import java.util.Objects;

public class SprintResponse {

    private final String name;
    private final String description;
    private final Instant creationDate;
    private final Instant startDate;
    private final Instant endDate;
    private final String projectName;

    private SprintResponse(Builder builder) {
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        startDate = builder.startDate;
        endDate = builder.endDate;
        projectName = builder.projectName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprintResponse that = (SprintResponse) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(projectName, that.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, creationDate, startDate, endDate, projectName);
    }

    public static final class Builder {
        private String name;
        private String description;
        private Instant creationDate;
        private Instant startDate;
        private Instant endDate;
        private String projectName;

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

        public Builder withProjectName(String val) {
            projectName = val;
            return this;
        }

        public SprintResponse build() {
            return new SprintResponse(this);
        }
    }
}
