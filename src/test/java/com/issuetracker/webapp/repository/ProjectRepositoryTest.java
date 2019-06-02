package com.issuetracker.webapp.repository;

import com.issuetracker.webapp.provider.ProjectProvider;
import com.issuetracker.webapp.repository.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.MapKeyColumn;

import java.util.Optional;

import static com.issuetracker.webapp.provider.ProjectProvider.emptyRepositoryProject;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TestEntityManager entityManager;

//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void test(){
        entityManager.persist(emptyRepositoryProject());
        entityManager.flush();

        Optional<Project> project = projectRepository.findById(ProjectProvider.id);
    }

}