package com.issuetracker.webapp.service;

import com.issuetracker.webapp.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findByEmail(String email);
    List<User> searchForUsers(String email, String username, String firstName, String lastName);
    List<User> findAllUsersOnAProject(Long projectId);
}
