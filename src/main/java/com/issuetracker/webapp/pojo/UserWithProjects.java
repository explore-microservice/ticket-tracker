package com.issuetracker.webapp.pojo;


import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserWithProjects {

    private User user;
    private Set<Project> projects;

    public void addProject(Project project){
        projects.add(project);
    }
}