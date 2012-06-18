package com.fancythinking.reg.hibernate_example.dal;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class TestUserBeanDAO extends SuperTest<UserBean> {

	
	
	public TestUserBeanDAO(String testName) {
		super(testName);

	}
	
	public void setUp() {
		dao = new UserBeanDAO();
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

	public void testFindByPrimaryKey() {
		UserBean b1 = createUserBean();
		long id = b1.getId();
		HibernateUtil.beginTransaction();
		logger.debug(">>>created: " + b1.toString());
		
		HibernateUtil.beginTransaction();
		UserBeanDAO dao = new UserBeanDAO();
		UserBean ub = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		logger.debug(">>>retrieved " + ub.toString());
		assertTrue( ub.getFirstName().equals(b1.getFirstName()) );

	}
	
	public void testFindByCriteria() {
		logger.debug("Test findByCriteria ");
		UserBean b1 = createUserBean();
		logger.debug(">>>created: " + b1.toString());
		
		UserBeanDAO dao = new UserBeanDAO();		
		UserBean ub1 = new UserBean();
		ub1.setUserName(b1.getUserName());
		
		HibernateUtil.beginTransaction();
		List<UserBean> list = dao.findByExample(ub1, true);
		HibernateUtil.commitTransaction();
		logger.debug("list size is " + list.size());
		assertTrue( list.size() == 1);
	}
	
	public void testFindAll() {
		logger.debug("Testing findAll()");
		HibernateUtil.beginTransaction();
		List<UserBean> ubList = new UserBeanDAO().findAll();
		HibernateUtil.commitTransaction();
		for ( UserBean ub : ubList ) {
			logger.debug(ub.toString());
		}
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
