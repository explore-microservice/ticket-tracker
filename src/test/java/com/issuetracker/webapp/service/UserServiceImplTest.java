package com.issuetracker.webapp.service;

import com.issuetracker.webapp.dao.UserRepository;
import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.utils.UserUtils;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.issuetracker.webapp.utils.UserUtils.aListOfUsers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private static final Long EXPECTED_USER_ID = 1L;
    private static final String EXPECTED_USER_EMAIL = "email@email.com";
    private static final List<User> EXPECTED_LIST_OF_USERS = aListOfUsers();
    private static final User EXPECTED_USER = UserUtils.aUser(EXPECTED_USER_ID, EXPECTED_USER_EMAIL);

    @Mock
    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeMethod
    private void init(){
        MockitoAnnotations.initMocks(this);
        this.userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void shouldReturnTheListOfUsersWhenRepositoryReturnsAListOfUsers() {
        when(userRepository.findAll()).thenReturn(EXPECTED_LIST_OF_USERS);
        assertThat(userService.getAllUsers(), equalTo(EXPECTED_LIST_OF_USERS));
    }

    @Test
    public void shouldReturnEmptyListWhenTheRepositoryReturnsAnEmptyList(){
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(userService.getAllUsers(), equalTo(Collections.EMPTY_LIST));
    }

    @Test
    public void shouldReturnOneUserWhenAFullEmailIsRequestedAndTheEmailExistsInTheDB(){
        when(userRepository.findAll()).thenCallRealMethod().thenReturn(EXPECTED_LIST_OF_USERS);
        assertThat(userService.getAUserByEmail(EXPECTED_USER_EMAIL),
                equalTo(EXPECTED_LIST_OF_USERS.stream()
                        .filter(user -> user.getEmail().equals(EXPECTED_USER_EMAIL))
                        .findFirst()
                        .orElse(null)));
    }
}