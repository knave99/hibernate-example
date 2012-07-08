package com.cloudshaped.generated;

import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class ProductTest extends TestCase {

	Logger logger = Logger.getLogger(ProductTest.class);

	static {  		
		HibernateUtil.setBeanList( new Class<?>[] { Product.class, Channel.class, Service.class, Productservice.class });
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	ServiceDAO sd = new ServiceDAO();
	public void testService() {
		HibernateUtil.beginTransaction();
		Set<Channel> channelSet;
		List<Service> serviceList = sd.findAll();
		logger.info("List of Services is ");
		for ( Service s : serviceList) {
			logger.info(s.getName() + "\n");
			channelSet = s.getChannels(); 
			
			for ( Channel c : channelSet) {
				logger.info("-->" + c.getName());	
			}
						
		}
		
		HibernateUtil.commitTransaction();
		
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
