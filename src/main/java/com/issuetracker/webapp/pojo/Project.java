package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "it_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NotNull Long id;
    private @NotNull String name;
    private String description;
    private @NotNull LocalDateTime creationdate;
    private LocalDateTime startdate;
    private LocalDateTime enddate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserWorkOnProject> users;
}
