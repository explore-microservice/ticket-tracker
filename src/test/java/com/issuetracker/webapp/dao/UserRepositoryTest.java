package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.pojo.UserRowMapper;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;


public class UserRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplateMock;

    private UserRepository userRepository;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplateMock);
    }

    @Test
    public void testFindAllShouldReturnEmptyListWhenJDBCTemplateReturnsEmptyList() {
        when(jdbcTemplateMock.query(UserRepository.findAllQuery, new UserRowMapper())).thenReturn(new ArrayList<>());
        assertThat("UserRepository should return empty list when jdbcTemplateMock returns empty list.",
                Collections.EMPTY_LIST, equalTo(userRepository.findAll()));
    }


    @Test
    public void testFindByIdShouldReturnAnEntryWithTheIdIfJDBCTemplateReturnsAnEntry(){
        User expectedUser = User.builder()
                .id(1L)
                .firstname("firstname")
                .lastname("lastname")
                .username("username")
                .password("password")
                .build();
        when(jdbcTemplateMock.queryForObject(UserRepository.findById, new Object[] { 1L }, new BeanPropertyRowMapper<>(User.class)))
                .thenReturn(expectedUser);

        User actualUser = userRepository.findById(1L);

        assertThat(actualUser, equalTo(expectedUser));
    }
}