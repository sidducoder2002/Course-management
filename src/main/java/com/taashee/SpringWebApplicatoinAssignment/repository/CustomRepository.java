package com.taashee.SpringWebApplicatoinAssignment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApplicatoinAssignment.entity.Instructor;
import com.taashee.SpringWebApplicatoinAssignment.entity.Student;
 
 
@Repository
public class CustomRepository {
	private static final String getAllInstructorsByStudentId =
            "SELECT DISTINCT i.* FROM student_course sc \r\n"
            + "JOIN instructor_course icr ON sc.course_id = icr.course_id \r\n"
            + "JOIN instructor i ON icr.instructor_id = i.id \r\n"
            + "WHERE sc.student_id = ?;";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Instructor> getAllInstructorsByStudentId(int studentId) {
        return jdbcTemplate.query(getAllInstructorsByStudentId, new Object[]{studentId}, new InstructorRowMapper());
    }
    private static class InstructorRowMapper implements RowMapper<Instructor> {
        @Override
        public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
            int instructor_id = rs.getInt("id");
            String instructor_name = rs.getString("name");
            String instructor_email = rs.getString("email");
            String instructor_qualification = rs.getString("qualification");
            return new Instructor(instructor_id, instructor_name, instructor_email, instructor_qualification);
        }
    }
 
 
    private static final String GET_STUDENTS_BY_COURSE_AND_INSTRUCTOR =
    	    "SELECT DISTINCT s.* " +
    	    "FROM student_course sc " +
    	    "JOIN student s ON sc.student_id = s.id " +
    	    "JOIN instructor_course icr ON sc.course_id = icr.course_id " +
    	    "JOIN instructor i ON icr.instructor_id = i.id " +
    	    "WHERE sc.course_id = ? AND i.id = ?";
    public List<Student> getStudentsByCourseAndInstructor(int courseId, int instructorId) {
        return jdbcTemplate.query(GET_STUDENTS_BY_COURSE_AND_INSTRUCTOR, new Object[]{courseId, instructorId}, new StudentRowMapper());
    }
    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getString("date_of_birth"));
            // You might need to handle the courses here depending on your requirement
            return student;
        }
    }
 
}