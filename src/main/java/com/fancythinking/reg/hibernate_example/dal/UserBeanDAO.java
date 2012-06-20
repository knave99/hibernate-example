package com.fancythinking.reg.hibernate_example.dal;


import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class UserBeanDAO extends DAO<UserBean, Long> implements IUserBeanDAO {
	
	public UserBeanDAO() {
		super(UserBean.class);
	}

}
