package com.issuetracker.webapp.controller.dto.response.project;

import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.util.List;

public class ProjectResponse {

    @ApiModelProperty(notes = "The name of the project.", position = 0)
    private final String name;
    @ApiModelProperty(notes = "The description of the project.", position = 1)
    private final String description;
    @ApiModelProperty(notes = "The creation date of the project.", dataType = "integer", position = 2)
    private final Instant creationDate;
    @ApiModelProperty(notes = "The start date of the project.", dataType = "integer", position = 3)
    private final Instant startDate;
    @ApiModelProperty(notes = "The end date of the project.", dataType = "integer", position = 4)
    private final Instant endDate;
    @ApiModelProperty(notes = "All the available sprints in the particular project.", dataType = "array", position = 5)
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

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public static final class Builder {
        private String name;
        private String description;
        private Instant creationDate;
        private Instant startDate;
        private Instant endDate;
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

        public Builder withSprints(List<Sprint> val) {
            sprints = val;
            return this;
        }

        public ProjectResponse build() {
            return new ProjectResponse(this);
        }
    }
}
