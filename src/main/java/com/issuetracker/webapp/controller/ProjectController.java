package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Project;
import com.issuetracker.webapp.service.ProjectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

//    private final ProjectService projectService;
//
//    public ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
//    public Project getProjectById(@PathVariable Long id) throws ProjectNotFoundException {
//        return projectService.getProjectById(id);
//    }
}
