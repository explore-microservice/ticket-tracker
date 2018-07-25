package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.pojo.UserRowMapper;
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

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepository(jdbcTemplate);
    }

    @Test
    public void shouldReturnEmptyListWhenJDBCTemplateReturnsEmptyList() {
        when(jdbcTemplate.query(FIND_ALL_QUERY, userRepository.userRowMapper)).thenReturn(new ArrayList<>());
        assertThat("UserRepository should return empty list when jdbcTemplate returns empty list.",
                Collections.EMPTY_LIST, equalTo(userRepository.findAll()));
    }

    @Test
    public void shouldReturnAllEntriesFromDB(){
        List<User> expectedUsers = Arrays.asList(
                User.builder().id(1L).firstname("John").lastname("Doe").username("john_doe").password("unhackable").build(),
                User.builder().id(2L).firstname("Katy").lastname("Doe").username("katy_doe").password("canyouhackthis?").build(),
                User.builder().id(3L).firstname("Mary").lastname("Paris").username("mary_paris").password("trythisone").build(),
                User.builder().id(3L).firstname("Mike").lastname("Gile").username("mike_gile").password("stronghuhh").build()
        );
        when(jdbcTemplate.query(FIND_ALL_QUERY, userRepository.userRowMapper)).thenReturn(expectedUsers);
        List<User> actualUsers = userRepository.findAll();
        assertThat(actualUsers, equalTo(expectedUsers));
    }


    @Test
    public void shouldReturnAnEntryWithTheIdIfJDBCTemplateReturnsAnEntry(){
        User expectedUser = User.builder()
                .id(1L)
                .firstname("firstname")
                .lastname("lastname")
                .username("username")
                .password("password")
                .lastLoggedIn(LocalDateTime.now())
                .build();

        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { 1L }, userRepository.userRowMapper)).thenReturn(expectedUser);
        User actualUser = userRepository.findById(1L);
        assertThat(actualUser, equalTo(expectedUser));
    }

    @Test
    public void shouldReturnNullWhenThereIsNoEntryInForTheRequestedId(){
        when(jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { 1L }, userRepository.userRowMapper)).thenReturn(null);
        User actualUser = userRepository.findById(1L);
        assertThat(actualUser, equalTo(null));
    }
}