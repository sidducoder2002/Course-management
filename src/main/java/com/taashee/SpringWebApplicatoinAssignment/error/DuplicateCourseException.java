package com.taashee.SpringWebApplicatoinAssignment.error;

public class DuplicateCourseException extends RuntimeException {
    public DuplicateCourseException(String message) {
        super(message);
    }
}