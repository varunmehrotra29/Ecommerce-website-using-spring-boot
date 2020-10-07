package com.springboot.login.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_details")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;

	@Column(name = "fisrtname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "mobile")
	private String mobileNumber;
	
	@Column(name = "email",unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "usertype")
	private String userType;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "dateactive")
	private LocalDate date;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String firstname, String lastname,String mobileNumber, String password ,String userType) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber=mobileNumber;
		this.password = password;
		this.userType=userType;
		this.status="active";
		this.date=LocalDate.now();
	}

	
	
	public int getId() {
		return id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}

}
