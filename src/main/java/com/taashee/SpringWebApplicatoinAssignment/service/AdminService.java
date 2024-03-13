package com.taashee.SpringWebApplicatoinAssignment.service;

import java.util.List;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;

public interface AdminService {
    // Methods for retrieving data
    List<Instructor> getAllInstructors();
    List<Course> getAllCourses();
    List<Student> getAllStudents();
    
    // Methods for adding data
    void addInstructor(Instructor instructor);
    void addCourse(Course course);
    void addStudent(Student student);
    
    
    void assignClassToInstructor(int instructorId, int courseId);
	Instructor assignCourseToInstructor(int instructor_id, int course_id);
}
