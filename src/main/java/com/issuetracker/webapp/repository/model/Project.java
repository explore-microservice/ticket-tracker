package com.issuetracker.webapp.repository.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity(name = "it_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creationdate")
    private LocalDateTime creationDate;
    @Column(name = "startdate")
    private LocalDateTime startDate;
    @Column(name = "enddate")
    private LocalDateTime endDate;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public Set<Works> getUsersWorkingOnIt() {
        return usersWorkingOnIt;
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
        private LocalDateTime creationDate;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Set<Sprint> sprints;
        private Set<Works> usersWorkingOnIt;

        public Builder() {
        }

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
