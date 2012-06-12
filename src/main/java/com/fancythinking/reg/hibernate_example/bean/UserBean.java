package com.fancythinking.reg.hibernate_example.bean;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class UserBean {

	private Long id;
	private String password;
	private String userName;
	private String firstName;
	private String lastName;
	private Calendar myCal;
	private Date dateOfBirth;
	private String fondestMemory;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Lob
	public String getFondestMemory() {
		return fondestMemory;
	}
	public void setFondestMemory(String fondestMemory) {
		this.fondestMemory = fondestMemory;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column (name="login_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column (name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column (name="last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Transient
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Temporal(TemporalType.DATE)
	public Calendar getMyCal() {
		return myCal;
	}
	public void setMyCal(Calendar myCal) {
		this.myCal = myCal;
	}
	
	
	public String printMe() {
		return "id: "+  getId() + " user: " + getUserName() + " password: " + getPassword(); 
	}
	
}