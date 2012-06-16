package com.fancythinking.reg.hibernate_example.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.CarBeanDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;
import com.fancythinking.reg.hibernate_example.dal.NameXDAO;

public class TestNameX extends SuperTest {

	NameXDAO dao = new NameXDAO();
	
	public TestNameX(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}
	
	private void createName(NameX cb) {		
		HibernateUtil.beginTransaction();
		dao.save(cb);
		HibernateUtil.commitTransaction();		
	}

	public void testCreate() {
		NameX x = new NameX("Stuart", "Reg");
		createName(x);
		Long id = x.getId();		
		assertTrue(id != null);
	}
	
	public void testDestroy() {
		NameX x = new NameX("For", "Destroy");
		createName(x);
				
		HibernateUtil.beginTransaction();
		Long id = x.getId();
		logger.debug("To delete " + x.toString());
		dao.delete(x);
		x = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		assertTrue( null == x );
	}
	
	private NameX findBean(Long id) {
		NameX x = null;		
		HibernateUtil.beginTransaction();
		{
			x = dao.findByPrimaryKey(id);
		}
		HibernateUtil.commitTransaction();
		return x;
	}
	
	public void testUpdate() {
		NameX x = new NameX("Stuart", "Reg1");
		createName(x);
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
