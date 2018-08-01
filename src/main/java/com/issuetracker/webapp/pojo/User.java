package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "it_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String username;
    private @NotNull String email;
    private @NonNull String password;
    private LocalDateTime lastloggedin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<UserWorkOnProject> projects;
}