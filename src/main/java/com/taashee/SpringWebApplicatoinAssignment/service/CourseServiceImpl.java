package com.taashee.SpringWebApplicatoinAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;
import com.taashee.SpringWebApplicatoinAssignment.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    
    @Override
    public Course createCourse(Course course) {
		  return courseRepository.save(course);
        
    }

    @Override
    public Course updateCourse(int id, Course course) {
    	 course.setId(id); // Ensure the correct ID is set
         return courseRepository.save(course); // Update or save the course
       
    }

    @Override
    public void deleteCourse(int id) {
    	 courseRepository.deleteById(id);
    }


	@Override
	public Course getCourseById(int id) {
		
		return null;
	}
	/*
	 * @Override public List<Course> getCoursesByInstructorName(String
	 * instructorName) { return
	 * courseRepository.findCoursesByInstructorName(instructorName); }
	 */


	@Override
	public List<Course> getCoursesByInstructorName(String instructorName) {
		
		return null;
	}


	@Override
	public boolean isCourseExists(String name) {
		
		return courseRepository.existsByName(name);
	}


	@Override
	public boolean isEmailExists(String email) {
		
		return courseRepository.existsByName(email);
	}



}

