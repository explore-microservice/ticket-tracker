package com.issuetracker.webapp.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity(name = "it_user")
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "lastloggedin")
    private LocalDateTime lastLoggedIn;
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<Ticket> createdTickets;
    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private Set<Ticket> assignedTickets;
    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "user")
    private Set<Works> worksOnProjects;

    protected User() {
    }

    private User(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        username = builder.username;
        email = builder.email;
        password = builder.password;
        lastLoggedIn = builder.lastLoggedIn;
        createdTickets = builder.createdTickets;
        assignedTickets = builder.assignedTickets;
        comments = builder.comments;
        worksOnProjects = builder.worksOnProjects;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getLastLoggedIn() {
        return lastLoggedIn;
    }

    public Set<Ticket> getCreatedTickets() {
        return createdTickets;
    }

    public Set<Ticket> getAssignedTickets() {
        return assignedTickets;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Works> getWorksOnProjects() {
        return worksOnProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastLoggedIn=" + lastLoggedIn +
                ", createdTickets=" + createdTickets +
                ", assignedTickets=" + assignedTickets +
                ", comments=" + comments +
                ", worksOnProjects=" + worksOnProjects +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        private LocalDateTime lastLoggedIn;
        private Set<Ticket> createdTickets;
        private Set<Ticket> assignedTickets;
        private Set<Comment> comments;
        private Set<Works> worksOnProjects;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withUsername(String val) {
            username = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withLastLoggedIn(LocalDateTime val) {
            lastLoggedIn = val;
            return this;
        }

        public Builder withCreatedTickets(Set<Ticket> val) {
            createdTickets = val;
            return this;
        }

        public Builder withAssignedTickets(Set<Ticket> val) {
            assignedTickets = val;
            return this;
        }

        public Builder withComments(Set<Comment> val) {
            comments = val;
            return this;
        }

        public Builder withWorksOnProjects(Set<Works> val) {
            worksOnProjects = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}