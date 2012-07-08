package com.cloudshaped.generated;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class ChannelTest extends TestCase {
	
	static {  		
		HibernateUtil.setBeanList( new Class<?>[] { Product.class, Channel.class, Service.class, Productservice.class });
	}
	
	Logger logger = Logger.getLogger(ChannelTest.class);
	
	public ChannelTest(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}
	
	

	


	
	ChannelDAO cd = new ChannelDAO();
	public void testChannel() {

		HibernateUtil.beginTransaction();
		Channel c = cd.findByPrimaryKey(1L);
		logger.debug("name is " + c.getName());
		assertTrue(c.getName().trim().equalsIgnoreCase("BBC1"));
		HibernateUtil.commitTransaction();
	}


}
