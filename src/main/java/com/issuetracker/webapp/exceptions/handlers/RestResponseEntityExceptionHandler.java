package com.issuetracker.webapp.exceptions.handlers;

import com.issuetracker.webapp.exceptions.TicketStatusCannotBeEmptyException;
import com.issuetracker.webapp.exceptions.dto.response.StatusResponse;
import com.issuetracker.webapp.exceptions.ProjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StatusResponse statusResponse = new StatusResponse(status);
        statusResponse.addValidationErrors(ex.getBindingResult().getFieldErrors());

//        return handleExceptionInternal(ex, new StatusResponse("Validation error", status), headers, status, request);
        return new ResponseEntity<>(statusResponse, status);
    }


//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(ProjectNotFoundException.class)
//    public ResponseEntity<StatusResponse> handleProjectNotFoundException(Exception ex){
//        logger.error(ex.getMessage(), ex);
//        return new ResponseEntity<>(
//                new StatusResponse("Project not found", HttpStatus.NOT_FOUND), new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(TicketStatusCannotBeEmptyException.class)
//    public StatusResponse handleTicketStatusCannotBeEmptyException(Exception ex){
//        logger.error(ex.getMessage(), ex);
//        return new StatusResponse("Status field of ticket cannot be empty", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
