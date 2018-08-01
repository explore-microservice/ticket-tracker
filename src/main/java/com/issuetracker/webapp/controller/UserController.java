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
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserByEmail(@RequestParam("email") String email){
        return userService.getAUserByEmail(email);
    }

    @RequestMapping(value = "/searchforuser", method = RequestMethod.GET)
    public List<User> searchForUsers(
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "username", required = false, defaultValue = "") String username,
            @RequestParam(value = "firstname", required = false, defaultValue = "") String firstName,
            @RequestParam(value = "lastname", required = false, defaultValue = "") String lastName){
        return userService.searchForUsers(email, username, firstName, lastName);
    }

    @RequestMapping(value = "/project/{projectid}/users", method = RequestMethod.GET)
    public List<User> getAllUserOnProject(@PathVariable(value = "projectid") Long projectId){
        return userService.getAllUsersOnAProject(projectId);
    }
}
