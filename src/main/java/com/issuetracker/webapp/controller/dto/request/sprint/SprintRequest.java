package com.issuetracker.webapp.controller.dto.request.sprint;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;
import java.util.Objects;

@JsonDeserialize(builder = SprintRequest.Builder.class)
public class SprintRequest {

    private final String name;
    private final String description;
    private final Instant startDate;
    private final Instant endDate;
    private final Long projectId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Long getProjectId() {
        return projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprintRequest that = (SprintRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, startDate, endDate, projectId);
    }

    private SprintRequest(Builder builder) {
        name = builder.name;
        description = builder.description;
        startDate = builder.startDate;
        endDate = builder.endDate;
        projectId = builder.projectId;
    }


    public static final class Builder {
        private String name;
        private String description;
        private Instant startDate;
        private Instant endDate;
        private Long projectId;

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

        public Builder withProjectId(Long val) {
            projectId = val;
            return this;
        }

        public SprintRequest build() {
            return new SprintRequest(this);
        }
    }
}
