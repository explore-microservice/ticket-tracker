package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class User {

    private @NonNull Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String username;
    private @NonNull String email;
    private @NonNull String password;
    private LocalDateTime lastLoggedIn;
}