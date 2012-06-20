package com.fancythinking.reg.hibernate_example.dal;

import java.util.Calendar;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class TestUserBeanDAO extends SuperTest<UserBean, Long> {

	
	
	public TestUserBeanDAO(String testName) {
		super(testName);

	}
	
	public void setUp() {
		dao = DAOFactory.getInstance().getUserBeanDAO();
	}
	
	protected UserBean createUserBean() {
		UserBean user = new UserBean();
		dao.beginTransaction();
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
		dao.save(user);
		dao.commitTransaction();
		return user;
	}

	public void testFindByPrimaryKey() {
		UserBean b1 = createUserBean();
		long id = b1.getId();
		dao.beginTransaction();
		logger.debug(">>>created: " + b1.toString());
		
		dao.beginTransaction();
		UserBeanDAO dao = new UserBeanDAO();
		UserBean ub = dao.findByPrimaryKey(id);
		dao.commitTransaction();
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
		
		dao.beginTransaction();
		List<UserBean> list = dao.findByExample(ub1, true);
		dao.commitTransaction();
		logger.debug("list size is " + list.size());
		assertTrue( list.size() == 1);
	}
	
	public void testFindAll() {
		logger.debug("Testing findAll()");
		dao.beginTransaction();
		List<UserBean> ubList = dao.findAll(new UserBean());
		dao.commitTransaction();
		for ( UserBean ub : ubList ) {
			logger.debug(ub.toString());
		}
	}

	@Override
	public void testCreate() {

		
	}

	@Override
	public void testUpdate() {
		
	}

	@Override
	public void testDestroy() {
		
	}

}
