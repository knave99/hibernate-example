package com.fancythinking.reg.hibernate_example.bean;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;



public class TestYounger extends SuperTest {

	
	Logger logger = Logger.getLogger(TestYounger.class);
	{
		logger.setLevel(Level.INFO);
	}
	
	public TestYounger(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}

	public void testYoungerThan() {
		
		System.out.println("Hello");
		logger.debug("Testing YoungerThan");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1995);
		UserBean ub1 = createUserBean(cal.getTime());		
		Session session = HibernateUtil.beginTransaction();
		Query query = session.getNamedQuery("user.youngerThan");
		cal.set(Calendar.YEAR, 1990);
		query.setDate("dob", cal.getTime());
		List<UserBean> list = query.list();		

		
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		logger.info("Listing " +  list.size() + " users with dates of birth > " + df.format(cal.getTime()));
		for ( UserBean ub : list ) {
			logger.info("user name: "+ ub.getUserName() + " dob: " + ub.getDateOfBirth());
		}
		
		
		Query query1 = HibernateUtil.getSession().createQuery("from UserBean where dateOfBirth > :dob AND userName LIKE :userName");
		query1.setDate("dob", cal.getTime());
		query1.setString("userName", "Reg 0.3%");
		list = query1.list();
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		
		logger.info("Listing " +  list.size() + " users names");
		for ( UserBean ub : list ) {
			logger.info("user name: "+ ub.getUserName() + " dob: " + ub.getDateOfBirth());
		}
	}
	protected UserBean createUserBean() {
		return createUserBean(null);		
	}
	
	protected UserBean createUserBean(Date date) {
		UserBean user = new UserBean();
		Session session = HibernateUtil.beginTransaction();
		user.setUserName("Reg " + Math.random());
		user.setFirstName("FN: Reg " + Math.random());
		user.setLastName("LN: Stuart " + Math.random());
		user.setPassword("Password " + Math.random());

		Calendar cal = Calendar.getInstance();
		if ( date == null ) {
			cal.set(Calendar.YEAR, 1975);
			cal.set(Calendar.MONTH, 4);
			cal.set(Calendar.DAY_OF_MONTH, 5);
			cal.set(Calendar.HOUR, 13);
			cal.set(Calendar.MINUTE, 12);
			cal.set(Calendar.SECOND, 15);			
		} else {
			cal.setTime(date);
		}

		user.setMyCal(cal);		
		user.setDateOfBirth(cal.getTime());
		user.setFondestMemory("This is my fondest memory!  blah blah blah!");
		session.saveOrUpdate(user);
		HibernateUtil.commitTransaction(session);
		return user;
	}

	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDestroy() {
		// TODO Auto-generated method stub
		
	}
}
