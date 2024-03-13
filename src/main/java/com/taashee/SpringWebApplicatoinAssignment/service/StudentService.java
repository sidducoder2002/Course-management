package com.taashee.SpringWebApplicatoinAssignment.service;

import java.util.List;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;

public interface StudentService {

	Student findByName(String username);

	List<Instructor> findInstructorNamesByStudentId(int id);

	List<Course> getAllStudentCourses(int student_id);

	
}
