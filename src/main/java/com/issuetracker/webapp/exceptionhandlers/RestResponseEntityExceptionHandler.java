package com.issuetracker.webapp.exceptionhandlers;

import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import com.issuetracker.webapp.pojo.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Status> handleProjectNotFoundException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                Status.builder().message("Project not found").httpStatus(HttpStatus.NOT_FOUND).build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
