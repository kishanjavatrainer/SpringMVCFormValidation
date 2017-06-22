package com.infotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotEmpty
	@Pattern(regexp="[^0-9]+")
	@Size(min=6,max=20)
	@Column(name = "student_name")
	private String studentName;
	
	@NotEmpty
	@Column(name = "gender")
	private String gender;
	
	@Size(min=1)
	@NotNull
	@Column(name = "technology")
	private String technology;
	
	@NotEmpty
	@Column(name = "city")
	private String city;
	
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Min(value = 1000000000)
	@Column(name = "phone")
	private Long phone;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getPhone() {
		return phone;
	}
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
}
