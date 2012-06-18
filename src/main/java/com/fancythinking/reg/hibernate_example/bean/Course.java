package com.fancythinking.reg.hibernate_example.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table	(name="tbl_course")
public class Course {
	private Long courseId;
	private String name;
	
	private List<Student> studentList;
	
	@OneToMany	(	mappedBy="course",
					targetEntity=Student.class,
					fetch=FetchType.EAGER,
					cascade=CascadeType.ALL
					
				)
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Id
	@GeneratedValue
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
