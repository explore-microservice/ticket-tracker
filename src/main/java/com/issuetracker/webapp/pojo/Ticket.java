package com.issuetracker.webapp.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity(name = "it_ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creationdate")
    private LocalDateTime creationDate;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprintid")
    private Sprint sprint;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatoruserid")
    private User creator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigneeuserid")
    private User assignee;
    @OneToMany(mappedBy = "ticket")
    private Set<Comment> comments;

    public Ticket() {
    }

    private Ticket(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        creationDate = builder.creationDate;
        type = builder.type;
        status = builder.status;
        sprint = builder.sprint;
        creator = builder.creator;
        assignee = builder.assignee;
        comments = builder.comments;
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

    public Sprint getSprint() {
        return sprint;
    }

    public User getCreator() {
        return creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", sprint=" + sprint +
                ", creator=" + creator +
                ", assignee=" + assignee +
                ", comments=" + comments +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private LocalDateTime creationDate;
        private Type type;
        private Status status;
        private Sprint sprint;
        private User creator;
        private User assignee;
        private Set<Comment> comments;

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

        public Builder withType(Type val) {
            type = val;
            return this;
        }

        public Builder withStatus(Status val) {
            status = val;
            return this;
        }

        public Builder withSprint(Sprint val) {
            sprint = val;
            return this;
        }

        public Builder withCreator(User val) {
            creator = val;
            return this;
        }

        public Builder withAssignee(User val) {
            assignee = val;
            return this;
        }

        public Builder withComments(Set<Comment> val) {
            comments = val;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
