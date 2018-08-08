package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class Project {

    private @NonNull Long id;
    private @NonNull String name;
    private String description;
    private @NonNull LocalDateTime creationDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
