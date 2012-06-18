package com.fancythinking.reg.hibernate_example.bean;

import java.util.ArrayList;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.CourseDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class CourseTest extends SuperTest<Course> {

	public CourseTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() {
		dao = new CourseDAO();
	}

	public Course createCourse() {
		Course c1 = new Course();
		c1.setName("Physics101");
		Student s1 = new Student();
		s1.setFirstName("Reg");
		s1.setLastName("Stuart");
		s1.setCourse(c1);		
		Student s2 = new Student();
		s2.setFirstName("Jayne");
		s2.setLastName("Thoday");
		s2.setCourse(c1);
		List<Student> l = new ArrayList<Student>();
		l.add(s1);
		l.add(s2);
		c1.setStudentList(l);
		create(c1);

		return c1;
	}
	
	@Override
	public void testCreate() {
		Course c1 = createCourse();
		Long id = c1.getCourseId();
		c1 = null;
		c1 = findBean(id);		
		assertTrue(c1.getCourseId() != null);
		assertTrue(c1.getStudentList().get(0).getId() != null);
		assertTrue(c1.getStudentList().get(1).getId() != null);
	}

	@Override
	public void testUpdate() {
		String chemistry = "Chemistry 101";
		String first = "Bob";
		Course c1 = createCourse();
		
		HibernateUtil.beginTransaction();
		Long id = c1.getCourseId();
		c1.setName(chemistry);
		c1.getStudentList().get(0).setFirstName(first);
		dao.save(c1);
		c1 = null;
		c1 = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		
		assertTrue(chemistry.equals(c1.getName()));
		assertTrue(first.equals(c1.getStudentList().get(0).getFirstName()));
	}

	@Override
	public void testDestroy() {
		Course c1 = createCourse();
		HibernateUtil.beginTransaction();		
		dao.delete(c1);
		c1 = dao.findByPrimaryKey(c1.getCourseId());
		HibernateUtil.commitTransaction();
		
		assertTrue(c1 == null);
	}

}
