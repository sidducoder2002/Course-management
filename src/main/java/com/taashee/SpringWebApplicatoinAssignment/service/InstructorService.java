package com.taashee.SpringWebApplicatoinAssignment.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
@Service
public interface InstructorService {

	Instructor findByInstructorName(String username);

 
 
}
