package com.issuetracker.webapp.controller.dto.request.project;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;

@JsonDeserialize(builder = ProjectRequest.Builder.class)
public class ProjectRequest {

    private final Long id;
    private final String name;
    private final String description;
    private final Instant startDate;
    private final Instant endDate;

    public Long getId() {
        return id;
    }

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

    private ProjectRequest(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }

    public static final class Builder {
        private String name;
        private String description;
        private Instant startDate;
        private Instant endDate;
        private Long id;

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

        public ProjectRequest build() {
            return new ProjectRequest(this);
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }
    }
}
