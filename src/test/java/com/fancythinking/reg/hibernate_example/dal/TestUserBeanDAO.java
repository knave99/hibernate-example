package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class TestUserBeanDAO extends SuperTest {

	
	
	public TestUserBeanDAO(String testName) {
		super(testName);

	}

	public void testFindByPrimaryKey() {
		UserBean b1 = create();
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
		UserBean b1 = create();
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

}
