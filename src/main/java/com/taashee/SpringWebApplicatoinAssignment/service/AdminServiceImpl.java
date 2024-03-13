package com.taashee.SpringWebApplicatoinAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
import com.taashee.SpringWebApplicatoinAssignment.repository.CourseRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.InstructorRepository;
import com.taashee.SpringWebApplicatoinAssignment.repository.StudentRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    
    
    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void assignClassToInstructor(int instructorId, int courseId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (instructor != null && course != null) {
            instructor.getCourses().add(course);
            instructorRepository.save(instructor);
        }
    }

 // Assigning a course to Instructor
 	@Override
 	public Instructor assignCourseToInstructor(int instructor_id, int course_id) {
 		Course c = courseRepository.findById(course_id).get();
 		Instructor i = instructorRepository.findById(instructor_id).get();
 		if (c != null && i != null) {
 			i.getCourses().add(c);
 		}
 		return instructorRepository.save(i);
 	}
}
