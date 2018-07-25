package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.UserRowMapper;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    private JdbcTemplate jdbcTemplate;

    private UserRepository userRepository;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplate);
    }

    @Test
    public void testShouldReturnEmptyListWhenJDBCTemplateReturnsEmptyList() {
        when(jdbcTemplate.query("SELECT * FROM it_user;", new UserRowMapper())).thenReturn(new ArrayList<>());
        assertThat("UserRepository should return empty list when jdbcTemplate returns empty list.",
                Collections.EMPTY_LIST, equalTo(userRepository.findAll()));
    }
}