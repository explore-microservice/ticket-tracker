package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.issuetracker.webapp.dao.UserRepository.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

public class UserRepositoryTest {

    private static final String A_USER_USERNAME = "aUserName";
    private static final String A_USER_PASSWORD = "aPassword";
    private static final String A_USER_FIRST_NAME = "aFirstName";
    private static final String A_USER_LAST_NAME = "aLastName";
    private static final Long EXPECTED_USER_ID = 1L;
    private static final User EXPECTED_USER = aUser(EXPECTED_USER_ID);
    private static final List<User> EXPECTED_LIST_OF_USERS = aListOfUsers();

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

    private static User aUser(Long id) {
        return User.builder()
                .firstname(A_USER_FIRST_NAME)
                .lastname(A_USER_LAST_NAME)
                .username(A_USER_USERNAME)
                .password(A_USER_PASSWORD)
                .id(id)
        .build();
    }

    private static List<User> aListOfUsers(){
        return Arrays.asList(
                aUser(1L),
                aUser(2L),
                aUser(3L),
                aUser(4L)
        );
    }
}