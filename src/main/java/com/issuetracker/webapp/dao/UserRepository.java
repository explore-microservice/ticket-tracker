package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import com.issuetracker.webapp.pojo.UserRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    final static String findAllQuery = "SELECT * FROM it_user;";
    final static String findById = "SELECT * FROM it_user WHERE id=?;";
    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long id){
        return jdbcTemplate.queryForObject(findById, new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> findAll(){
        return jdbcTemplate.query(findAllQuery, new UserRowMapper());
    }
}
