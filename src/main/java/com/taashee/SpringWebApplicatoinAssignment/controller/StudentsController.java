package com.taashee.SpringWebApplicatoinAssignment.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.error.StudentNotFoundException;
import com.taashee.SpringWebApplicatoinAssignment.service.StudentService;
 
 
 
@Controller
public class StudentsController {
 
	@Autowired
	private StudentService studentService;
	

	@PreAuthorize(value = "hasRole('ROLE_STUDENT')")
	@GetMapping("/student")
    public String getInstructorNamesByStudentId (ModelMap modelMap, Principal principal) {
		String username = principal.getName();
		Student student = studentService.findByName(username);
		if (student == null) {
            throw new StudentNotFoundException("Student not found with name: " + username);
        }

		List<Instructor> list = studentService.findInstructorNamesByStudentId(student.getId());
        modelMap.put("instructors", list);
        modelMap.put("student", student);
        modelMap.addAttribute("username",username);
		return "instructor-list";
    }
	
	@PreAuthorize(value = "hasRole('ROLE_STUDENT')")
	@GetMapping("/courses")
    public String getCoursesByStudentId(ModelMap modelMap, Principal principal) {
        String username = principal.getName();
        Student student = studentService.findByName(username);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with name: " + username);
        }
        modelMap.put("student", student);
        return "instructor-list";
    }
}