package com.cloudshaped.generated;

import java.util.Calendar;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class UserTest extends TestCase {

	Logger logger = Logger.getLogger(UserTest.class);
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testCreate() {
		Userbean ub = createUserbean();
		logger.debug("First name is " + ub.getFirstName());
	}
	
	protected Userbean createUserbean() {
		HibernateUtil.setBeanList(new Class<?>[] { Userbean.class } );
		Userbean user = new Userbean();
		
		Session session = HibernateUtil.beginTransaction();
		user.setLoginName("Reg " + Math.random());
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
		user.setDateofbirth(cal.getTime());
		user.setFondestmemory("This is my fondest memory!  blah blah blah!");
		session.saveOrUpdate(user);
		HibernateUtil.commitTransaction(session);
		return user;
	}

}
