package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NotNull Long id;
    private @NotNull String name;
    private String description;
    private @NotNull LocalDateTime creationdate;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
}
