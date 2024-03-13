package com.taashee.SpringWebApplicatoinAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
/*import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.error.DuplicateCourseException;
import com.taashee.SpringWebApplicatoinAssignment.repository.CourseRepository;
import com.taashee.SpringWebApplicatoinAssignment.service.AdminService;
import com.taashee.SpringWebApplicatoinAssignment.service.CourseService;
import com.taashee.SpringWebApplicatoinAssignment.service.InstructorService;

@Controller

public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private CourseService courseService;
	

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Instructor> instructors = adminService.getAllInstructors();
		List<Course> courses = adminService.getAllCourses();
		List<Student> students = adminService.getAllStudents();
		model.addAttribute("instructors", instructors);
		model.addAttribute("courses", courses);
		model.addAttribute("students", students);
		return "admin_dashborad";
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/addInstructor")
	public String addInstructor(@RequestParam String name, @RequestParam String email,
			@RequestParam String qualification) {	     
		Instructor instructor = new Instructor();
		instructor.setName(name);
		instructor.setEmail(email);
		instructor.setQualification(qualification);
		adminService.addInstructor(instructor);
		return "redirect:/dashboard";
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam String name, @RequestParam String description, @RequestParam String startDate,
			@RequestParam String endDate) {
		boolean test = courseService.isCourseExists(name);
		if (test) {
		    throw new DuplicateCourseException("Course with name " + name + " already exists");
		}
		Course course = new Course();
		course.setName(name);
		course.setDescription(description);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		adminService.addCourse(course);
		return "redirect:/dashboard";
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/addStudent")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam String dateOfBirth) {
		Student student = new Student();
		
		
		student.setName(name);
		student.setEmail(email);
		student.setDateOfBirth(dateOfBirth);
		adminService.addStudent(student);
		return "redirect:/dashboard";
	}


	
	@GetMapping("/assignClassForm") 
	 public String showAssignClassForm(Model model) { 
		  List<Course> allCourses = adminService.getAllCourses(); //
		 model.addAttribute("allCourses", allCourses); 
		 List<Instructor> allInstructors = adminService.getAllInstructors();
		 model.addAttribute("allInstructors", allInstructors); 
		 return "assignClass";
	 }

	
	// Assign a Particular course to the particular instructor
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/assignCourse")
	public String assign(@RequestParam int instructor_id, @RequestParam int course_id, ModelMap modelMap) {
		adminService.assignCourseToInstructor(instructor_id, course_id);
		//List<Course> allCourses = adminService.getAllCourses();
//		model.addAttribute("allCourses", allCourses);
		//return getAllInstructors(modelMap);
		return "redirect:/dashboard";

	}
	

}
