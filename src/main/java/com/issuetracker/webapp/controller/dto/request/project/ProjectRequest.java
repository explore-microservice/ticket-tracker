package com.issuetracker.webapp.controller.dto.request.project;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ExampleProperty;

import java.time.Instant;
import java.util.Objects;

@JsonDeserialize(builder = ProjectRequest.Builder.class)
public class ProjectRequest {

    @ApiModelProperty(notes = "New name for your project", example = "Dummy project", required = false, position = 0)
    private final String name;
    @ApiModelProperty(notes = "New description for your project", example = "Some description here", required = false, position = 1)
    private final String description;
    @ApiModelProperty(notes = "New start date for your project", example = "1559427577", required = false, position = 2)
    private final Instant startDate;
    @ApiModelProperty(notes = "New end date for your project", example = "1559427585", required = false, position = 3)
    private final Instant endDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectRequest that = (ProjectRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, startDate, endDate);
    }

    private ProjectRequest(Builder builder) {
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
    }
}
