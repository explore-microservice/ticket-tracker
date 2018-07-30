package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User userByEmail(@RequestParam("email") String email){
        return userService.findByEmail(email);
    }
}
