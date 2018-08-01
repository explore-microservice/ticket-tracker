package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private @NonNull Long id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String username;
    private @NotNull String email;
    private @NonNull String password;
    private LocalDateTime lastLoggedIn;
}