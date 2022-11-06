package com.idfc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String gender;

	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private long phno;
	
	private String education;
	
	private String dept;
	
	@ColumnDefault("'patient'")
	private String userType = "patient";
	
	@Column(nullable = false)
	private String password;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	public User(int userId, String name, String gender, String address, String city, String email, long phno,
			String education, String dept, String userType, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phno = phno;
		this.education = education;
		this.dept = dept;
		this.userType = userType;
		this.password = password;
	}
}
