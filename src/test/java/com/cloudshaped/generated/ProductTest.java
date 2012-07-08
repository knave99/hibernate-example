package com.cloudshaped.generated;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fancythinking.reg.hibernate_example.bean.UserBean;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class ProductTest extends TestCase {

	Logger logger = Logger.getLogger(ProductTest.class);

	static {  		
		HibernateUtil.setBeanList( new Class<?>[] { Product.class, Channel.class, Service.class, Productservice.class });
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	
	ProductDAO pdao = new ProductDAO();
	public void testProduct() {
		logger.info("Test Product");
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
	
	public void testServices() {
		logger.info("Test Services");
		HibernateUtil.beginTransaction();

		Product bigBundle = new Product();
		bigBundle.setName("Big");
		Set<Service> services;
		List<Product> list = pdao.findByExample(bigBundle, true);
		logger.info("Product list is for fuzzy search Big is:");
		
		Set<Channel> channels;
		for ( Product p : list) {
			logger.info(p.getName());
			services = p.getServices();
			for ( Service s : services ) {
				logger.info("-->"+ s.getName());
				channels = s.getChannels();
				for ( Channel c : channels ) {
					logger.info("---->" + c.getName());
				}
			}
		}
		assertTrue( list.size() == 1);
		 
		
		
		HibernateUtil.commitTransaction();
		
	}
	
	public void testHQL() {
		logger.info("HQL Test");
		HibernateUtil.beginTransaction();
		Session session = HibernateUtil.getSession();
		
		
		Query query = session.getNamedQuery("product.findFree");				
		List<Product> productList = (List<Product>) query.list();
		logger.info(productList.size() + " products found with free services.");
		
		Set<Service> services;
		Set<Channel> channels;
		for ( Product p : productList) {
			logger.warn(p.getName().trim() + " is Free? " + p.getIsFree());
			services = p.getServices();
			for ( Service s : services ) {
				logger.info("-->"+ s.getName().trim() + " is Free? " + s.isFree());
				channels = s.getChannels();
				for ( Channel c : channels ) {
					logger.info("---->" + c.getName().trim() + " is Free? " + c.getIsFree());
				}
			}
		}

		 
		
		
		HibernateUtil.commitTransaction();		
	}
	
	public void testCreateProduct() {
		logger.info("Test Create");
		HibernateUtil.beginTransaction();

		Product bundle = new Product();
		String myBundleName = "My Bundle" + Math.random();
		bundle.setName(myBundleName);
		bundle.setIsFree(false);
		Set<Service> serviceSet = new HashSet<Service>();
		ServiceDAO serviceDAO = new ServiceDAO();
		Service service = serviceDAO.findByPrimaryKey(1L);
		serviceSet.add(service);
		pdao.save(bundle);
		
		
		bundle = new Product();
		bundle.setName(myBundleName);
		List<Product> result = pdao.findByExample(bundle, true);
		assertTrue(result.size() == 1);
		HibernateUtil.commitTransaction();	
	}
	


	
}
