package com.taashee.SpringWebApplicatoinAssignment.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApplicatoinAssignment.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	 //@Query("SELECT c FROM Course c JOIN c.instructor i WHERE i.name = :name")
	 //List<Course> findCoursesByInstructorName(String name);

	//List<Course> findByInstructorId(int id);

	//List<Course> findByInstructorId(int id);
	
	 @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Course c WHERE LOWER(c.name) = LOWER(:name)")
	  boolean existsByName(@Param("name") String name);
}
