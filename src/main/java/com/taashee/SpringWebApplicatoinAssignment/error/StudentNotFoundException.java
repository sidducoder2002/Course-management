package com.taashee.SpringWebApplicatoinAssignment.error;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
