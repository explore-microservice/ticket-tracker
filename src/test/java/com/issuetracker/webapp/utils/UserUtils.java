package com.issuetracker.webapp.utils;

import com.issuetracker.webapp.pojo.User;

import java.util.Arrays;
import java.util.List;

public abstract class UserUtils {

    private static final String A_USER_USERNAME = "aUserName";
    private static final String A_USER_PASSWORD = "aPassword";
    private static final String A_USER_FIRST_NAME = "aFirstName";
    private static final String A_USER_LAST_NAME = "aLastName";

    public static User aUser(Long id) {
        return User.builder()
                .firstname(A_USER_FIRST_NAME)
                .lastname(A_USER_LAST_NAME)
                .username(A_USER_USERNAME)
                .password(A_USER_PASSWORD)
                .id(id)
                .build();
    }

    public static List<User> aListOfUsers(){
        return Arrays.asList(
                aUser(1L),
                aUser(2L),
                aUser(3L),
                aUser(4L)
        );
    }
}
