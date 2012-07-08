package com.cloudshaped.generated;

// Generated 08-Jul-2012 17:47:20 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Userbean generated by hbm2java
 */
@Entity
@Table(name = "userbean", schema = "public")
public class Userbean implements java.io.Serializable {

	private long id;
	private Date dateofbirth;
	private String firstName;
	private String fondestmemory;
	private String lastName;
	private Date mycal;
	private String password;
	private String loginName;

	public Userbean() {
	}

	public Userbean(long id) {
		this.id = id;
	}

	public Userbean(long id, Date dateofbirth, String firstName,
			String fondestmemory, String lastName, Date mycal, String password,
			String loginName) {
		this.id = id;
		this.dateofbirth = dateofbirth;
		this.firstName = firstName;
		this.fondestmemory = fondestmemory;
		this.lastName = lastName;
		this.mycal = mycal;
		this.password = password;
		this.loginName = loginName;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateofbirth", length = 29)
	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "fondestmemory")
	public String getFondestmemory() {
		return this.fondestmemory;
	}

	public void setFondestmemory(String fondestmemory) {
		this.fondestmemory = fondestmemory;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mycal", length = 13)
	public Date getMycal() {
		return this.mycal;
	}

	public void setMycal(Date mycal) {
		this.mycal = mycal;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "login_name")
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
