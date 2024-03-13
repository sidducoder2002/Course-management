package com.taashee.SpringWebApplicatoinAssignment.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.repository.CustomRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.StudentRepository;


 
@Service
public class StudentServiceImpl implements StudentService {
 
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CustomRepository customRepo;
 
	@Override
	public List<Course> getAllStudentCourses(int student_id) {
		Student s = studentRepo.findById(student_id).get();
		return new ArrayList<>(s.getCourses());
	}
 
	@Override
	public List<Instructor> findInstructorNamesByStudentId(int student_id) {
		return customRepo.getAllInstructorsByStudentId(student_id);
	}
 
	@Override
	public Student findByName(String username) {
		return studentRepo.findByName(username);
	}

	
}