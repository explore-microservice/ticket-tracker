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
}
