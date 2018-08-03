package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.issuetracker.webapp.dao.UserRepository.FIND_ALL_QUERY;
import static com.issuetracker.webapp.dao.UserRepository.FIND_ALL_USERS_WHO_WORKS_ON_PROJECT;
import static com.issuetracker.webapp.dao.UserRepository.FIND_USER_BY_ID_QUERY;
import static com.issuetracker.webapp.utils.UserUtils.aListOfUsers;
import static com.issuetracker.webapp.utils.UserUtils.aUser;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class UserRepositoryTest {

    private static final Long EXPECTED_USER_ID = 1L;
    private static final User EXPECTED_USER = aUser(EXPECTED_USER_ID);
    private static final List<User> EXPECTED_LIST_OF_USERS = aListOfUsers();

    private static final Long EXPECTED_PROJECT_ID = 1L;

    @Mock
    private JdbcTemplate jdbcTemplate;
    private UserRepository userRepository;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplate);
    }

    @Test
    public void shouldReturnEmptyListWhenJDBCTemplateReturnsEmptyList() {
        when(jdbcTemplate.query(FIND_ALL_QUERY, userRepository.userRowMapper)).thenReturn(new ArrayList<>());
        assertThat(Collections.EMPTY_LIST, equalTo(userRepository.findAll()));
    }

    @Test
    public void shouldReturnAllEntriesFromDBWhenThereIsAnyInTheDB(){
        when(jdbcTemplate.query(FIND_ALL_QUERY, userRepository.userRowMapper)).thenReturn(EXPECTED_LIST_OF_USERS);
        List<User> actualUsers = userRepository.findAll();
        assertThat(actualUsers, equalTo(EXPECTED_LIST_OF_USERS));
    }

    @Test
    public void shouldReturnAnEntryWithTheIdIfJDBCTemplateReturnsAnEntry(){
        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { EXPECTED_USER_ID }, userRepository.userRowMapper)).thenReturn(EXPECTED_USER);
        User actualUser = userRepository.findById(EXPECTED_USER_ID);
        assertThat(actualUser, equalTo(EXPECTED_USER));
    }

    @Test
    public void shouldReturnNullWhenThereIsNoEntryInForTheRequestedId(){
        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { EXPECTED_USER_ID }, userRepository.userRowMapper)).thenReturn(null);
        User actualUser = userRepository.findById(EXPECTED_USER_ID);
        assertThat(actualUser, equalTo(null));
    }

    @Test
    public void shouldReturnAllUsersWhoWorksOnProjectWhenThereAreEntriesInTheDB(){
        when(jdbcTemplate.query(FIND_ALL_USERS_WHO_WORKS_ON_PROJECT, new Object[] { EXPECTED_PROJECT_ID }, userRepository.userRowMapper)).thenReturn(EXPECTED_LIST_OF_USERS);
        List<User> actualUsersWhoWorkOnProject = userRepository.findAllUsersOnAProject(EXPECTED_PROJECT_ID);
        assertThat(actualUsersWhoWorkOnProject, equalTo(EXPECTED_LIST_OF_USERS));
    }

    @Test(expectedExceptions = ProjectNotFoundException.class)
    public void shouldThrowExceptionWhenThereIsNoProjectInTheDBWithTheRequestedId(){
        when(jdbcTemplate.query(FIND_ALL_USERS_WHO_WORKS_ON_PROJECT, new Object[] { EXPECTED_PROJECT_ID }, userRepository.userRowMapper)).thenThrow(ProjectNotFoundException.class);
        userRepository.findAllUsersOnAProject(EXPECTED_PROJECT_ID);
    }

    @Test
    public void shouldReturnEmptyListOfUsersWhenThereIsNoOneWorkingOnARequestedProject(){
        when(jdbcTemplate.query(FIND_ALL_USERS_WHO_WORKS_ON_PROJECT, new Object[] { EXPECTED_PROJECT_ID }, userRepository.userRowMapper)).thenReturn(new ArrayList<>());
        assertThat(userRepository.findAllUsersOnAProject(EXPECTED_PROJECT_ID), equalTo(Collections.EMPTY_LIST));
    }


}