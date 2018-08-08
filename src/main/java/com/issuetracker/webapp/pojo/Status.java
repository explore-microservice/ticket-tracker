package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Status {
    private String message;
    private HttpStatus httpStatus;
}
