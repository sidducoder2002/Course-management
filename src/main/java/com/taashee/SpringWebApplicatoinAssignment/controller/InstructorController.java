package com.taashee.SpringWebApplicatoinAssignment.controller;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.error.InstructorNotFoundException;
import com.taashee.SpringWebApplicatoinAssignment.repository.CourseRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.CustomRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.InstructorRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.StudentRepository;
 
@Controller
public class InstructorController {
	@Autowired
	private InstructorRepository instructorRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private CustomRepository customRepo;
	@Autowired
	private StudentRepository studentRepo;
	
	@PreAuthorize(value = "hasRole('ROLE_INSTRUCTOR')")
	@GetMapping("/instructor")
	public String getInstructors(ModelMap modelMap,Principal principal){
		String username = principal.getName();
		
		Instructor instructor = instructorRepo.findByInstructorName(username);
		if (instructor == null) {
		    throw new InstructorNotFoundException("Instructor not found with name: " + username);
		}

		List<Course> courses = new ArrayList<>(instructor.getCourses());
		List<Student> students = new ArrayList<>();
		for(Course course : courses) {
			List<Student> student = customRepo.getStudentsByCourseAndInstructor(course.getId(), 
					instructor.getId());
			for(Student st : student) {
				if(!students.contains(st)) {
					students.add(st);
				}
			}
		}
		List<Student> all_studennts = studentRepo.findAll();
		modelMap.addAttribute("courses", courses);
		modelMap.addAttribute("instructor", instructor);
		modelMap.addAttribute("students", students);
		modelMap.addAttribute("allstudennts", all_studennts);
		modelMap.addAttribute("username",username);
		return "instructor-display";
	}
	//@PreAuthorize(value = "hasRole('ROLE_INSTRUCTOR')")
	@PostMapping("/assigncoursetostudent")
	public String assignCourseToStudent(@RequestParam int studentId, @RequestParam int courseId) {
		Student student = studentRepo.findById(studentId).get();
		Course course = courseRepo.findById(courseId).get();
		student.getCourses().add(course);
		studentRepo.save(student);
		return "redirect:/instructor";
	}

}