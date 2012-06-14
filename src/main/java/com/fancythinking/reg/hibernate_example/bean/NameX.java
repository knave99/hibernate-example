package com.fancythinking.reg.hibernate_example.bean;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table	(name="tbl_waiting_list")
public class NameX {
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private Long id;
	private String firstName;
	private String surname;
	
	public NameX() {}
	public NameX(String lastName, String firstName) {
		surname = lastName;
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return surname + ", " + firstName + " id: " + id;
	}
}
