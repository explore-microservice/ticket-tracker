package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userService.getAUserById(id);
    }

    @RequestMapping(value = "/searchforusers", method = RequestMethod.GET)
    public List<User> searchForUsers(
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "username", required = false, defaultValue = "") String username,
            @RequestParam(value = "firstname", required = false, defaultValue = "") String firstName,
            @RequestParam(value = "lastname", required = false, defaultValue = "") String lastName){
        return userService.searchForUsers(email, username, firstName, lastName);
    }

    @RequestMapping(value = "/project/{projectid}/users", method = RequestMethod.GET)
    public List<User> getAllUserOnProject(@PathVariable(value = "projectid") Long projectId) throws ProjectNotFoundException {
        return userService.getAllUsersOnAProject(projectId);
    }
}
