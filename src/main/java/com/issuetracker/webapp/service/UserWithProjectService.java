package com.issuetracker.webapp.service;

import com.issuetracker.webapp.pojo.UserWithProjects;

import java.util.Collection;

public interface UserWithProjectService {

    Collection<UserWithProjects> getAllUsersWithProject();
}
