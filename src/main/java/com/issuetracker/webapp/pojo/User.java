package com.issuetracker.webapp.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NotNull Long id;
    private @NotNull String firstname;
    private @NotNull String lastname;
    private @NotNull String username;
    private @NotNull String password;
    private LocalDateTime lastLoggedIn;

    public User() { }

    public User(String firstname, String lastname, String username, String password, LocalDateTime lastLoggedIn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.lastLoggedIn = lastLoggedIn;
    }
}