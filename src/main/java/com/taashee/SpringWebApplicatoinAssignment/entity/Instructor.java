package com.taashee.SpringWebApplicatoinAssignment.entity;
import javax.persistence.*;



import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor {
    @Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", qualification=" + qualification
				+ ", courses=" + courses + "]";
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String qualification;
    
    public Instructor(int id, String name, String email, String qualification, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.courses = courses;
	}
    public Instructor(int id, String name, String email, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.qualification = qualification;
	}


	public Instructor() {

	}


	@ManyToMany()
    @JoinTable(
            name = "instructor_course",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id") )
    private Set<Course> courses = new HashSet<>();
    

  
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
	
}
