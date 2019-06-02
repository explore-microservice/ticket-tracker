package com.issuetracker.webapp.service;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.provider.ProjectProvider;
import com.issuetracker.webapp.repository.ProjectRepository;
import com.issuetracker.webapp.repository.model.Project;
import com.issuetracker.webapp.service.converter.ProjectRequestConverter;
import com.issuetracker.webapp.service.converter.ProjectResponseConverter;
import com.issuetracker.webapp.service.dto.response.project.ProjectResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.issuetracker.webapp.provider.ProjectProvider.aRepositoryProjectWithCreationDate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectServiceImplTest {

    @Mock private ProjectRepository projectRepository;
    @Mock private ProjectResponseConverter serviceProjectResponseConverter;
    @Mock private ProjectRequestConverter serviceProjectRequestConverter;
    private ProjectServiceImpl projectService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        projectService = new ProjectServiceImpl(projectRepository,
                serviceProjectResponseConverter,
                serviceProjectRequestConverter);
    }

    @Test
    public void givenProjectWithoutAttributes_whenGet() throws ProjectNotFoundException {
        Project anEmptyProject = aRepositoryProjectWithCreationDate();
        ProjectResponse projectResponse = ProjectProvider.emptyServiceProjectResponse();

        Mockito.when(projectRepository.findById(1L)).thenReturn(Optional.of(anEmptyProject));
        Mockito.when(serviceProjectResponseConverter.convert(anEmptyProject)).thenReturn(projectResponse);

        assertThat(projectResponse, equalTo(projectService.getProject(1L)));
    }
}