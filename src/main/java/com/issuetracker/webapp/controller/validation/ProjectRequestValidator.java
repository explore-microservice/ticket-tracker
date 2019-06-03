package com.issuetracker.webapp.controller.validation;

import com.issuetracker.webapp.controller.dto.request.project.ProjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProjectRequestValidator implements ConstraintValidator<ProjectRequestValid, ProjectRequest> {

   private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRequestValidator.class);

   public void initialize(ProjectRequestValid constraint) {
   }

   public boolean isValid(ProjectRequest payload, ConstraintValidatorContext context) {

      if(payload.getName() == null || payload.getName().equals("")){
         LOGGER.warn("Project name cannot be empty or null");
         return false;
      }
      if(payload.getStartDate().isAfter(payload.getEndDate())){
         LOGGER.warn("Project start date cannot be set before the project end date");
         return false;
      }

      return true;
   }
}
