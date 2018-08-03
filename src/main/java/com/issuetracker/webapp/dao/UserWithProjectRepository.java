package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.UserResultSetExtractor;
import com.issuetracker.webapp.pojo.UserWithProjects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserWithProjectRepository {

    final static String FIND_ALL_USERS_AND_RELATED_PROJECTS = "SELECT * FROM it_user u LEFT OUTER JOIN it_userworksonproject uwp ON u.id = uwp.userid LEFT OUTER JOIN it_project p ON uwp.projectid = p.id;";
    private JdbcTemplate jdbcTemplate;

    UserResultSetExtractor userResultSetExtractor = new UserResultSetExtractor();

    public UserWithProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<UserWithProjects> findAllWithRelatedProjects(){
        return jdbcTemplate.query(FIND_ALL_USERS_AND_RELATED_PROJECTS, userResultSetExtractor);
    }
}
