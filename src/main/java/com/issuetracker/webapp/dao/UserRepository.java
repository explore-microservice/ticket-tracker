package com.issuetracker.webapp.dao;

import com.google.common.annotations.VisibleForTesting;
import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.pojo.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    final static String FIND_USER_BY_ID_QUERY = "SELECT * FROM it_user WHERE id=?;";
    final static String FIND_ALL_QUERY = "SELECT * FROM it_user;";
    final static String FIND_ALL_USERS_AND_RELATED_PROJECTS = "SELECT u.*, p.* FROM it_user u LEFT OUTER JOIN it_userworksonproject uwp ON u.id = uwp.userid LEFT OUTER JOIN it_project p ON uwp.projectid = p.id;";
    final static String FIND_ALL_USERS_WHO_WORKS_ON_PROJECT = "SELECT * FROM it_user u INNER JOIN it_userworksonproject uwp ON u.id = uwp.userid WHERE uwp.projectid=?";
    private JdbcTemplate jdbcTemplate;

    @VisibleForTesting
    UserRowMapper userRowMapper = new UserRowMapper();

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long id){
        return jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { id }, userRowMapper);
    }

    public List<User> findAll(){
        return jdbcTemplate.query(FIND_ALL_QUERY, userRowMapper);
    }

    public List<User> findAllUsersOnAProject(Long projectId){
        return jdbcTemplate.query(FIND_ALL_USERS_WHO_WORKS_ON_PROJECT, new Object[] { projectId }, userRowMapper);
    }
}
