package com.fancythinking.reg.hibernate_example.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

/**
 * Unit test for simple App.
 */
public class TestUserBean extends SuperTest {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */

	Logger logger = Logger.getLogger(TestUserBean.class);
	
	public TestUserBean(String testName) {
		super(testName);
	}

	
	long createdBeanId = 0;
	long createdBeanIdToDestroy = 0;
	
	private UserBean create() {
		UserBean user = new UserBean();
		Session session = HibernateUtil.beginTransaction();
		user.setUserName("Reg " + Math.random());
		user.setFirstName("FN: Reg " + Math.random());
		user.setLastName("LN: Stuart " + Math.random());
		user.setPassword("Password " + Math.random());
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1975);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.HOUR, 13);
		cal.set(Calendar.MINUTE, 12);
		cal.set(Calendar.SECOND, 15);
		user.setMyCal(cal);		
		user.setDateOfBirth(cal.getTime());
		user.setFondestMemory("This is my fondest memory!  blah blah blah!");
		session.saveOrUpdate(user);
		HibernateUtil.commitTransaction(session);
		return user;
	}

	public void testCreate() {
		UserBean user1 = create();
		createdBeanId = user1.getId();		
		assertTrue(null != user1.getId());	// user id is non-null				
	}
	
	@SuppressWarnings("unchecked")
	public void testRetrieveList() {
		List<UserBean> userList;
		create();
		Session session = HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from UserBean");		
		userList = (List<UserBean>) query.list();		
		HibernateUtil.commitTransaction(session);
		for ( UserBean u : userList ) {
			logger.debug("User: " + u.getUserName() + " Pass: " + u.getPassword() + " id: " + u.getId());
		}
		
		assertTrue( userList.size() > 0 );
	}
	
	
	
	public void testRetrieveHQL() {
		UserBean user = create();
		long id = user.getId(); 
		String userName = user.getUserName();
		user = null;
		user = getUserWithHQL(id);
		assertTrue( user.getUserName().equals(userName) );
	}
	
	private UserBean getUserWithHQL(long id) {
		String querySting = "FROM UserBean WHERE id = :id";
		Session session = HibernateUtil.beginTransaction();		
		Query query = session.createQuery(querySting);
		query.setLong("id", id);
		UserBean user = (UserBean) query.uniqueResult();
		
		HibernateUtil.commitTransaction(session);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public void testUpdate() {
		String tempPass = "password";
		List<UserBean> userList;
		Session session = HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from UserBean");		
		userList = (List<UserBean>) query.list();
		for ( UserBean b : userList ) {
			b.setPassword(tempPass);
			session.save(b);
		}		
		HibernateUtil.commitTransaction(session);
		userList = null;
				
		session = HibernateUtil.beginTransaction();
		
		query = session.createQuery("from UserBean");		
		userList = (List<UserBean>) query.list();
		for ( UserBean b : userList ) {
			assertTrue( tempPass.equals(b.getPassword()) );		
		}
		HibernateUtil.commitTransaction(session);
		session = HibernateUtil.beginTransaction();
				
		query = session.createQuery("from UserBean");
		userList = (List<UserBean>) query.list();
		for ( UserBean b : userList ) {
			b.setPassword(String.valueOf(Math.random()));
			session.update(b);
		}		
		HibernateUtil.commitTransaction(session);
	}
	
	public void testDestroy() {
		UserBean user = create();
		long id = user.getId();
		Session session = HibernateUtil.beginTransaction();
		session.delete(user);
		HibernateUtil.commitTransaction(session);
		// delete the user
		
		
		user = getUserWithHQL(id); 
		
		
		assertTrue(null == user);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestUserBean.class);
	}
}
