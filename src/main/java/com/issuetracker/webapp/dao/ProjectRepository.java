package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;
import com.issuetracker.webapp.pojo.ProjectRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository {

    static final String FIND_PROJECT_BY_ID_QUERY = "SELECT * FROM it_project WHERE id=?;";
    private JdbcTemplate jdbcTemplate;
    private ProjectRowMapper projectRowMapper = new ProjectRowMapper();

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Project findById(Long id){
        Project project;
        try {
            project = jdbcTemplate.queryForObject(FIND_PROJECT_BY_ID_QUERY, new Object[] { id }, projectRowMapper);
        } catch (EmptyResultDataAccessException ex){
            throw new ProjectNotFoundException("Project not found in the DB.", ex);
        }
        return project;
    }
}
