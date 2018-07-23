package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> users(){
        return userService.getAllUsers();
    }
}
