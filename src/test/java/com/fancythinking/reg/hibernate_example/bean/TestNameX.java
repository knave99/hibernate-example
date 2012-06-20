package com.fancythinking.reg.hibernate_example.bean;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.DAOFactory;

public class TestNameX extends SuperTest<NameX, Long> {	
	
	public TestNameX(String testName) {
		super(testName);
	}
	
	public void setUp() {
		dao = DAOFactory.getInstance().getNameXDAO();
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
				
		dao.beginTransaction();
		Long id = x.getId();
		logger.debug("To delete " + x.toString());
		dao.delete(x);
		x = dao.findByPrimaryKey(id);
		dao.commitTransaction();
		assertTrue( null == x );
	}

	
	public void testUpdate() {
		NameX x = new NameX("Stuart", "Reg1");
		create(x);
		Long id = x.getId();
		
		 
		dao.beginTransaction();
		{ 	
				x.setFirstName("Bruce");				
				dao.save(x);
				x = findBean(id);
		}		
		dao.commitTransaction();
		
				
		assertTrue("Bruce".equals(x.getFirstName()));
	}


}
