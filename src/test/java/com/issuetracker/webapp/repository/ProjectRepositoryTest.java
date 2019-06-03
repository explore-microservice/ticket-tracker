package com.issuetracker.webapp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.issuetracker.webapp.provider.ProjectProvider.aRepositoryProjectWithCreationDate;
import static com.issuetracker.webapp.provider.ProjectProvider.aRepositoryProjectWithName;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private TestEntityManager entityManager;

    @Test(expected = DataIntegrityViolationException.class)
    public void givenProjectWithoutName_whenPersistAndFlushToTheDB_thenDataIntegrityViolationExceptionIsThrown(){
        projectRepository.saveAndFlush(aRepositoryProjectWithCreationDate());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void givenProjectWithoutCreationDate_whenPersistAndFlushToTheDB_thenDataIntegrityViolationExceptionIsThrown(){
        projectRepository.saveAndFlush(aRepositoryProjectWithName());
    }
}