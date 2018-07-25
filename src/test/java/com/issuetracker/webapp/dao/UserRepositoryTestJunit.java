package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTestJunit {

    @Mock
    private JdbcTemplate jdbcTemplateMock;

    private UserRepository userRepository;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplateMock);
    }

    @Test
    public void testFindById(){
        User expectedUser = User.builder()
                .id(1L)
                .firstname("firstname")
                .lastname("lastname")
                .username("username")
                .password("password")
                .build();
        when(jdbcTemplateMock.queryForObject(UserRepository.findById, new Object[] { 1L }, new BeanPropertyRowMapper<>(User.class)))
                .thenReturn(expectedUser);

        assertThat(userRepository.findById(1L), equalTo(expectedUser));
    }
}
