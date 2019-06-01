package com.issuetracker.webapp.repository.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "it_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "creationdate")
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketid")
    private Ticket ticket;

    public Comment() {
    }

    public Comment(String content, LocalDateTime creationDate, User author, Ticket ticket) {
        this.content = content;
        this.creationDate = creationDate;
        this.author = author;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", author=" + author +
                ", ticket=" + ticket +
                '}';
    }
}
