package com.taashee.SpringWebApplicatoinAssignment.service;
import java.util.List;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;

public interface CourseService {
    List<Course> getAllCourses();
   
    Course createCourse(Course course);
    Course updateCourse(int id, Course course);
    void deleteCourse(int id);

	Course getCourseById(int id);

	List<Course> getCoursesByInstructorName(String instructorName);

	 boolean isCourseExists(String name) ;

	boolean isEmailExists(String name);

	
}
