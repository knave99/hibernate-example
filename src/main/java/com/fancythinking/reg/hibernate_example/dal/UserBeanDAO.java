package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class UserBeanDAO extends DAO<UserBean> {
	
	public UserBean findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(UserBean.class, id);
	}
	
	public List<UserBean> findAll() {
		return super.findAll(new UserBean());
	}
	

	
}
