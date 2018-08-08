package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static com.issuetracker.webapp.dao.ProjectRepository.FIND_PROJECT_BY_ID_QUERY;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class ProjectRepositoryTest {

    private static final Long EXPECTED_PROJECT_ID = 1L;
    private static final String A_PROJECT_NAME = "aProject";
    private static final String A_PROJECT_DESCRIPTION = "aProjectDescription";
    private static final LocalDateTime A_PROJECT_CREATION_DATE = LocalDateTime.now();

    private static Project EXPECTED_PROJECT = aProject(EXPECTED_PROJECT_ID);

    @Mock
    private JdbcTemplate jdbcTemplate;
    private ProjectRepository projectRepository;

    @BeforeMethod
    private void init(){
        MockitoAnnotations.initMocks(this);
        projectRepository = new ProjectRepository(jdbcTemplate);
    }

    @Test
    public void shouldReturnRequestedProjectWhenItIsAvailableInTheDB() throws ProjectNotFoundException {
        when(jdbcTemplate.queryForObject(FIND_PROJECT_BY_ID_QUERY, new Object[] { EXPECTED_PROJECT_ID }, projectRepository.projectRowMapper)).thenReturn(EXPECTED_PROJECT);
        assertThat(projectRepository.findById(EXPECTED_PROJECT_ID), equalTo(EXPECTED_PROJECT));
    }

    @Test(expectedExceptions = ProjectNotFoundException.class)
    public void shouldReturnExceptionWhenTheRequestedProjectIsNotInTheDB() throws ProjectNotFoundException {
        when(jdbcTemplate.queryForObject(FIND_PROJECT_BY_ID_QUERY, new Object[] { EXPECTED_PROJECT_ID }, projectRepository.projectRowMapper)).thenThrow(EmptyResultDataAccessException.class);
        projectRepository.findById(EXPECTED_PROJECT_ID);
    }

    private static Project aProject(Long projectId){
        return Project.builder()
                .id(projectId)
                .name(A_PROJECT_NAME)
                .description(A_PROJECT_DESCRIPTION)
                .creationDate(A_PROJECT_CREATION_DATE)
                .build();
    }
}