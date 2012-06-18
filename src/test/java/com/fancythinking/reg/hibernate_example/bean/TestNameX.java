package com.fancythinking.reg.hibernate_example.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.CarBeanDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;
import com.fancythinking.reg.hibernate_example.dal.NameXDAO;

public class TestNameX extends SuperTest<NameX> {

	NameXDAO dao = new NameXDAO();
	
	public TestNameX(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}
	
	public void setUp() {
		dao = new NameXDAO();
	}


	public void testCreate() {
		NameX x = new NameX("Stuart", "Reg");
		create(x);
		Long id = x.getId();		
		assertTrue(id != null);
	}
	

	public void testDestroy() {
		NameX x = new NameX("For", "Destroy");
		create(x);
				
		HibernateUtil.beginTransaction();
		Long id = x.getId();
		logger.debug("To delete " + x.toString());
		dao.delete(x);
		x = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		assertTrue( null == x );
	}

	
	public void testUpdate() {
		NameX x = new NameX("Stuart", "Reg1");
		create(x);
		Long id = x.getId();
		
		 
		HibernateUtil.beginTransaction();
		{ 	
				x.setFirstName("Bruce");				
				dao.save(x);
		}		
		HibernateUtil.commitTransaction();
		
		x = findBean(id);		
		assertTrue("Bruce".equals(x.getFirstName()));
	}


}
