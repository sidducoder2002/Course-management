package com.taashee.SpringWebApplicatoinAssignment.service;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.repository.CourseRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.CustomRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.InstructorRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.StudentRepository;
 
@Service
public class InstructorServiceImpl implements InstructorService {
 
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private InstructorRepository instructorRepo;
	@Autowired
	private CustomRepository customRepo;
	@Override
	public Instructor findByInstructorName(String username) {
		
		return instructorRepo.findByInstructorName(username);
	}
	

 
}