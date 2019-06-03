package com.issuetracker.webapp.repository.model;

import com.google.common.annotations.VisibleForTesting;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity(name = "it_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creationdate", nullable = false)
    private Instant creationDate;
    @Column(name = "startdate")
    private Instant startDate;
    @Column(name = "enddate")
    private Instant endDate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Sprint> sprints;
    @OneToMany(mappedBy = "project")
    private Set<Works> usersWorkingOnIt;

    protected Project() {
    }

    private Project(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        startDate = builder.startDate;
        endDate = builder.endDate;
        sprints = builder.sprints;
        usersWorkingOnIt = builder.usersWorkingOnIt;
    }

    public Long getId() {
        return id;
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

    public Optional<Set<Sprint>> getSprints() {
        return Optional.ofNullable(sprints);
    }

    public Set<Works> getUsersWorkingOnIt() {
        return usersWorkingOnIt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public void setUsersWorkingOnIt(Set<Works> usersWorkingOnIt) {
        this.usersWorkingOnIt = usersWorkingOnIt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", sprints=" + sprints +
                ", usersWorkingOnIt=" + usersWorkingOnIt +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private Instant creationDate;
        private Instant startDate;
        private Instant endDate;
        private Set<Sprint> sprints;
        private Set<Works> usersWorkingOnIt;

        public Builder() {
        }

        @VisibleForTesting
        public Builder withId(Long val) {
            id = val;
            return this;
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

        public Builder withSprints(Set<Sprint> val) {
            sprints = val;
            return this;
        }

        public Builder withUsersWorkingOnIt(Set<Works> val) {
            usersWorkingOnIt = val;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
