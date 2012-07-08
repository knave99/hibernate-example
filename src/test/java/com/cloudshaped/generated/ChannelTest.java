package com.cloudshaped.generated;

import java.util.List;

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
	ProductDAO pdao = new ProductDAO();
	public void testProduct() {

		HibernateUtil.beginTransaction();

		Product bigBundle = new Product();
		bigBundle.setName("Big");
		List<Product> list = pdao.findByExample(bigBundle, true);
		logger.info("Product list is for fuzzy search Big is:");
		for ( Product p : list) {
			logger.info(p.getName());	
		}
		assertTrue( list.size() == 1);		
		HibernateUtil.commitTransaction();

	}

}
