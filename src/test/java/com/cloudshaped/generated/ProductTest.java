package com.cloudshaped.generated;

import java.util.Calendar;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class ProductTest extends TestCase {

	Logger logger = Logger.getLogger(ProductTest.class);

	static {  		
		HibernateUtil.setBeanList( new Class<?>[] { Product.class, Channel.class, Service.class, Productservice.class });
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	ServiceHome sh = new ServiceHome();


	ProductHome ph = new ProductHome();
	
	public void testProduct() {
		
		HibernateUtil.beginTransaction();
		Product p = ph.findById(1);
		logger.debug("name is " + p.getName());
		HibernateUtil.commitTransaction();
	}

	*/
	
	ChannelDAO cd = new ChannelDAO();
	public void testService() {

		HibernateUtil.beginTransaction();
		Channel c = cd.findByPrimaryKey(1L);
		logger.debug("name is " + c.getName());
		HibernateUtil.commitTransaction();
	}
	
}
