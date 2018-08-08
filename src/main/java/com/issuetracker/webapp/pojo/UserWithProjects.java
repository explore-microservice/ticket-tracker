package com.issuetracker.webapp.pojo;


import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Set;

@Data
@Builder(toBuilder = true)
public class UserWithProjects {

    private User user;
    @Singular
    private Set<Project> projects;
}