package com.fancythinking.reg.hibernate_example.dal;

import com.fancythinking.reg.hibernate_example.bean.Course;

public class CourseDAO extends DAO<Course, Long> implements ICourseDAO {

	public CourseDAO() {
		super(Course.class);
	}

}

