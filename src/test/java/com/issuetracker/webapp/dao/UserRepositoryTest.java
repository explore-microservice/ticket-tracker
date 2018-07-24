package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.UserRowMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplate);
    }

    @Test
    public void testEmptyList(){
        when(jdbcTemplate.query("SELECT * FROM it_user;", new UserRowMapper())).thenReturn(new ArrayList<>());
        assertThat("message", Collections.EMPTY_LIST, equalTo(userRepository.findAll()));
    }
}