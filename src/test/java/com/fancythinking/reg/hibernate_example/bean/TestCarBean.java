package com.fancythinking.reg.hibernate_example.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.CarBeanDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class TestCarBean extends SuperTest<CarBean> {

	public void setUp() {
		dao = new CarBeanDAO();
	}
	
	public TestCarBean(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}
	

	public void testCreate() {
		CarBean cb = new CarBean(new Date(), "Punto Grande", "Reg");
		List<NameX> waitingList =  new ArrayList<NameX>();
		waitingList.add(new NameX("Stuart", "Reg"));
		waitingList.add(new NameX("Stuart", "Jayne"));
		cb.setWaitingList(waitingList);
		create(cb);
		Long id = cb.getId();
		assertTrue(id != null);
		
		cb = null;
		cb = findBean(id);
		assertTrue( cb != null );
		assertTrue( cb.getWaitingList().isEmpty() != true );
		
		logger.debug(cb.toString());				
	}
	
	public void testDestroy() {
		CarBean cb = new CarBean(new Date(), "Destructoid", "Reg");
		create(cb);
		
		HibernateUtil.beginTransaction();
		Long id = cb.getId();
		logger.debug("To delete " + cb.toString());
		dao.delete(cb);
		cb = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		assertTrue( null == cb );
	}
	

	
	public void testUpdate() {
		CarBean cb = new CarBean(new Date(), "Updater", "Reg");
		create(cb);
		Long id = cb.getId();
		String model = "Diablo";
		 
		HibernateUtil.beginTransaction();
		{ 	
				cb.setModelName(model);
				cb.setOwner("Regmeister!");
				dao.save(cb);
		}		
		HibernateUtil.commitTransaction();
		
		cb = findBean(id);		
		assertTrue(cb.getModelName().equals(model));
	}


}
