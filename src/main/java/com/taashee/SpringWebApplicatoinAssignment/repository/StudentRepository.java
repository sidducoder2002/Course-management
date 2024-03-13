package com.taashee.SpringWebApplicatoinAssignment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApplicatoinAssignment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String username);
}
