package com.issuetracker.webapp.service;

import com.issuetracker.webapp.dao.UserWithProjectRepository;
import com.issuetracker.webapp.pojo.UserWithProjects;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserWithProjectServiceImpl implements UserWithProjectService {

    private final UserWithProjectRepository userWithProjectRepository;

    public UserWithProjectServiceImpl(UserWithProjectRepository userWithProjectRepository) {
        this.userWithProjectRepository = userWithProjectRepository;
    }

    @Override
    public Collection<UserWithProjects> getAllUsersWithProject() {
        return userWithProjectRepository.findAllWithRelatedProjects();
    }
}
