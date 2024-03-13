package com.taashee.SpringWebApplicatoinAssignment.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.taashee.SpringWebApplicatoinAssignment.error.DuplicateCourseException;

import com.taashee.SpringWebApplicatoinAssignment.error.InstructorNotFoundException;
import com.taashee.SpringWebApplicatoinAssignment.error.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(StudentNotFoundException.class)
	public String handleStudentNotFoundException(StudentNotFoundException ex) {
		// Create a custom error response
		return "studentNotFound";

	}

	@ExceptionHandler(InstructorNotFoundException.class)
	public String handleInstructorNotFoundException(InstructorNotFoundException ex) {
		// Create a custom error response

		return "instructorNotFound";
	}

	@ExceptionHandler(DuplicateCourseException.class)
	public String handleDuplicateCourseException(DuplicateCourseException ex) {
		return "NotAbleToAdd";
	}
	

	 
	// Add more exception handler methods as needed
}