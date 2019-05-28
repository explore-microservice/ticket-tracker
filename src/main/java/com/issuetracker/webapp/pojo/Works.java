package com.issuetracker.webapp.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "it_works")
public class Works {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectid")
    private Project project;

    public Works() {
    }

    public Works(User user, Project project) {
        this.user = user;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Works works = (Works) o;
        return Objects.equals(id, works.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Works{" +
                "id=" + id +
                ", user=" + user +
                ", project=" + project +
                '}';
    }
}