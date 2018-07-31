package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.Project;
import com.issuetracker.webapp.pojo.ProjectRowMapper;
import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Repository
public class ProjectRepository {

    private JdbcTemplate jdbcTemplate;
    private ProjectRowMapper projectRowMapper = new ProjectRowMapper();

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Project findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM it_project WHERE id=?;", new Object[] { id }, projectRowMapper);
    }
}
