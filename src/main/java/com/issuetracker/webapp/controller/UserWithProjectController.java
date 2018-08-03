package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.pojo.UserWithProjects;
import com.issuetracker.webapp.service.UserWithProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserWithProjectController {
    private final UserWithProjectService userWithProjectService;

    public UserWithProjectController(UserWithProjectService userWithProjectService) {
        this.userWithProjectService = userWithProjectService;
    }

    @RequestMapping(value = "/userswithproject", method = RequestMethod.GET)
    public Collection<UserWithProjects> getAllUsersWithProject(){
        return userWithProjectService.getAllUsersWithProject();
    }
}
