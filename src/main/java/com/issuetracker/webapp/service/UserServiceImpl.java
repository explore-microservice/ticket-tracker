package com.issuetracker.webapp.service;

import com.issuetracker.webapp.dao.UserRepository;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> searchForUsers(String email, String username, String firstName, String lastName) {
        return userRepository.findAll().stream()
                .filter(user ->
                        (!email.isEmpty() && user.getEmail().contains(email)) ||
                                (!username.isEmpty() && user.getUsername().contains(username)) ||
                                (!firstName.isEmpty() && user.getUsername().contains(firstName)) ||
                                (!lastName.isEmpty() && user.getUsername().contains(lastName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsersOnAProject(Long projectId) throws ProjectNotFoundException {
        return userRepository.findAllUsersOnAProject(projectId);
    }
}
