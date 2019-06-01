package com.issuetracker.webapp.repository.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity(name = "it_sprint")
public class Sprint {

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectid")
    private Project project;
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    protected Sprint() {
    }

    private Sprint(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        startDate = builder.startDate;
        endDate = builder.endDate;
        project = builder.project;
        tickets = builder.tickets;
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

    public Project getProject() {
        return project;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(id, sprint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", project=" + project +
                ", tickets=" + tickets +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private LocalDateTime creationDate;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Project project;
        private Set<Ticket> tickets;

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

        public Builder withProject(Project val) {
            project = val;
            return this;
        }

        public Builder withTickets(Set<Ticket> val) {
            tickets = val;
            return this;
        }

        public Sprint build() {
            return new Sprint(this);
        }
    }
}