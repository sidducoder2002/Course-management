package com.taashee.SpringWebApplicatoinAssignment.entity;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.SpringWebApplicatoinAssignment.security.UserRole;



@Entity(name = "users")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private String role;

	public User() {
		super();
	}

	public User(int id, String username, String password, String role) {
		super();
		this.userId = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public Set<SimpleGrantedAuthority> getAuthorities() {
		UserRole userRole = UserRole.STUDENT;
		if (role.equals(UserRole.ADMIN.name())) {
			userRole = UserRole.ADMIN;
		} else if (role.equals(userRole.INSTRUCTOR.name())) {
			userRole = UserRole.INSTRUCTOR;
		}
		Set<SimpleGrantedAuthority> permissions = userRole.getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + role));
		// read,write, ROLE_ADMIN,ROLE_USER
		return permissions;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
