package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM it_user WHERE id=?;", new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
    }
}
