package com.fancythinking.reg.hibernate_example;


import com.fancythinking.reg.hibernate_example.bean.UserBean;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

import junit.framework.TestCase;

public abstract class SuperTest extends TestCase {
	
	static {
		HibernateUtil.setBeanList( new Class<?>[] { UserBean.class });
	}
	
	public SuperTest(String testName) {
		super(testName);		
	}
	
}
