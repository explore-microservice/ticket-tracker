package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserByEmail(String email);
    User getUserById(Long id);
    List<User> searchForUsers(String email, String username, String firstName, String lastName);
    List<User> getAllUsersOnAProject(Long projectId) throws ProjectNotFoundException;
}
