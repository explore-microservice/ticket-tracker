package com.issuetracker.webapp.provider;

import com.issuetracker.webapp.repository.model.User;

import java.time.Instant;

public class UserProvider {

    public static Long id = 1L;
    public static String firstName = "firstname";
    public static String lastName = "lastname";
    public static String username = "username";
    public static String email = "email";
    public static String password = "password";
    public static Instant lastLoggedIn = Instant.now();

    public static User aUser(){
        return new User.Builder()
                .withId(id)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withUsername(username)
                .withEmail(email)
                .withPassword(password)
                .withLastLoggedIn(lastLoggedIn)
                .build();
    }
}
