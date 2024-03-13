package com.taashee.SpringWebApplicatoinAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


import com.taashee.SpringWebApplicatoinAssignment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	UserDetails findByUsername(String username);
}
