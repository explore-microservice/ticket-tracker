package com.issuetracker.webapp.service;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.pojo.UserWithProjects;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getAUserByEmail(String email);
    List<User> searchForUsers(String email, String username, String firstName, String lastName);
    List<User> getAllUsersOnAProject(Long projectId);
    Collection<UserWithProjects> getAllUsersWithProject();
}
