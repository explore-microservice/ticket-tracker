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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectServiceImplTest {

    @Mock private ProjectRepository projectRepository;
    @Mock private ProjectResponseConverter serviceProjectResponseConverter;
    @Mock private ProjectRequestConverter serviceProjectRequestConverter;
    private ProjectServiceImpl projectService;

    private static Long projectId = 1L;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        projectService = new ProjectServiceImpl(projectRepository,
                serviceProjectResponseConverter,
                serviceProjectRequestConverter);
    }

    @Test
    public void givenProjectIdAndProjectInDbWithoutSprints_whenGetterAProject_thenReturnProjectResponse() {
        Project aProjectWithoutSprints = ProjectProvider.aRepositoryProject();
        ProjectResponse projectResponse = ProjectProvider.aServiceProjectResponseWithoutSprints();

        Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.of(aProjectWithoutSprints));
        Mockito.when(serviceProjectResponseConverter.convert(aProjectWithoutSprints)).thenReturn(projectResponse);

        assertThat(projectResponse, equalTo(projectService.getProject(projectId)));
    }

    @Test
    public void givenProjectIdAndProjectInDbWithSprints_whenGetterAProject_thenReturnProjectResponse() {
        Project projectWithSprints = ProjectProvider.aRepositoryProjectWithSprints();
        ProjectResponse projectResponse = ProjectProvider.aServiceProjectResponseWithSprints();

        Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectWithSprints));
        Mockito.when(serviceProjectResponseConverter.convert(projectWithSprints)).thenReturn(projectResponse);

        assertThat(projectResponse, equalTo(projectService.getProject(projectId)));
    }

    @Test(expected = ProjectNotFoundException.class)
    public void givenProjectId_whenGetANonExistingProject_thenProjectNotFoundExceptionShouldBeThrown() {
        Mockito.when(projectRepository.findById(projectId)).thenThrow(ProjectNotFoundException.class);

        projectService.getProject(projectId);
    }

}