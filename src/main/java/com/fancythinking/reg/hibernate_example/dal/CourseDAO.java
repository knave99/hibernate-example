package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.bean.Course;

public class CourseDAO extends DAO<Course> {

	public Course findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(Course.class, id);
	}
	
	public List<Course> findAll() {
		return super.findAll(new Course());
	}
}
