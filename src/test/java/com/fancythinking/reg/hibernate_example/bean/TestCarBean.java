package com.fancythinking.reg.hibernate_example.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.DAOFactory;

public class TestCarBean extends SuperTest<CarBean, Long> {

	public void setUp() {
		dao = DAOFactory.getInstance().getCarBeanDAO();
	}
	
	public TestCarBean(String testName) {
		super(testName);
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
		dao.beginTransaction();
		cb = findBean(id);
		assertTrue( cb != null );
		assertTrue( cb.getWaitingList().isEmpty() != true );		
		dao.commitTransaction();

		
		logger.debug(cb.toString());				
	}
	
	public void testDestroy() {
		CarBean cb = new CarBean(new Date(), "Destructoid", "Reg");
		create(cb);
		
		dao.beginTransaction();
		Long id = cb.getId();
		logger.debug("To delete " + cb.toString());
		dao.delete(cb);
		cb = dao.findByPrimaryKey(id);
		dao.commitTransaction();
		assertTrue( null == cb );
	}
	

	
	public void testUpdate() {
		CarBean cb = new CarBean(new Date(), "Updater", "Reg");
		create(cb);
		Long id = cb.getId();
		String model = "Diablo";
		 
		dao.beginTransaction();
		{ 	
				cb.setModelName(model);
				cb.setOwner("Regmeister!");
				dao.save(cb);
				cb = findBean(id);	
		}		
		dao.commitTransaction();
		
			
		assertTrue(cb.getModelName().equals(model));
	}


}
