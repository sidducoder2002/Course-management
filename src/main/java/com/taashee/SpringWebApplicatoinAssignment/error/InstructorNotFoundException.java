package com.taashee.SpringWebApplicatoinAssignment.error;

public class InstructorNotFoundException extends RuntimeException {
    public InstructorNotFoundException(String message) {
        super(message);
    }
}