package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.issuetracker.webapp.dao.UserRepository.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

public class UserRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    private UserRepository userRepository;

    private static User.UserBuilder userBuilder = User.builder()
            .firstname(RandomStringUtils.random(8))
            .lastname(RandomStringUtils.random(8))
            .username(RandomStringUtils.random(8))
            .password(RandomStringUtils.random(8))
            .lastLoggedIn(LocalDateTime.now())
            .build().toBuilder();

    private static User getExpectedUser(){
        return userBuilder.id(1L).build();
    }

    private static List<User> getExpectedUsers(){
        return Arrays.asList(
                userBuilder.id(1L).build(),
                userBuilder.id(2L).build(),
                userBuilder.id(3L).build(),
                userBuilder.id(4L).build()
        );
    }

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
        when(jdbcTemplate.query(FIND_ALL_QUERY, userRepository.userRowMapper)).thenReturn(getExpectedUsers());
        List<User> actualUsers = userRepository.findAll();
        assertThat(actualUsers, equalTo(getExpectedUsers()));
    }

    @Test
    public void shouldReturnAnEntryWithTheIdIfJDBCTemplateReturnsAnEntry(){
        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { 1L }, userRepository.userRowMapper)).thenReturn(getExpectedUser());
        User actualUser = userRepository.findById(1L);
        assertThat(actualUser, equalTo(getExpectedUser()));
    }

    @Test
    public void shouldReturnNullWhenThereIsNoEntryInForTheRequestedId(){
        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { 1L }, userRepository.userRowMapper)).thenReturn(null);
        User actualUser = userRepository.findById(1L);
        assertThat(actualUser, equalTo(null));
    }
}