package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class Project {

    private @NotNull Long id;
    private @NotNull String name;
    private String description;
    private @NotNull LocalDateTime creationdate;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
}
