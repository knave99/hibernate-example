package com.fancythinking.reg.hibernate_example;


import java.util.Calendar;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.fancythinking.reg.hibernate_example.bean.CarBean;
import com.fancythinking.reg.hibernate_example.bean.NameX;
import com.fancythinking.reg.hibernate_example.bean.UserBean;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public abstract class SuperTest extends TestCase {
	
	static {
		HibernateUtil.setBeanList( new Class<?>[] { UserBean.class, CarBean.class, NameX.class });
	}
	
	protected Logger logger = Logger.getLogger(getClass());
	
	public SuperTest(String testName) {
		super(testName);		
	}
	
	protected UserBean createUserBean() {
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
	
}
