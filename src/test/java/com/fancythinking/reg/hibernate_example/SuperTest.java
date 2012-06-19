package com.fancythinking.reg.hibernate_example;


import java.io.Serializable;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.fancythinking.reg.hibernate_example.bean.BinaryFile;
import com.fancythinking.reg.hibernate_example.bean.CarBean;
import com.fancythinking.reg.hibernate_example.bean.Course;
import com.fancythinking.reg.hibernate_example.bean.InvoiceBean;
import com.fancythinking.reg.hibernate_example.bean.NameX;
import com.fancythinking.reg.hibernate_example.bean.Student;
import com.fancythinking.reg.hibernate_example.bean.UserBean;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;
import com.fancythinking.reg.hibernate_example.dal.IDAO;

public abstract class SuperTest<T, ID extends Serializable> extends TestCase {
	
	static {
		HibernateUtil.setBeanList( new Class<?>[] { 
				UserBean.class, 
				CarBean.class, 
				NameX.class, 
				Student.class, 
				Course.class,
				BinaryFile.class,
				InvoiceBean.class
		});
	}
	
	protected IDAO<T, ID> dao;
	protected Logger logger = Logger.getLogger(getClass());
	
	public SuperTest(String testName) {
		super(testName);		
	}
	
	public abstract void setUp();
	
	public void create(T cb) {		
		HibernateUtil.beginTransaction();
		dao.save(cb);
		HibernateUtil.commitTransaction();		
	}
	
	public T findBean(ID id) {		
		return (T) dao.findByPrimaryKey(id);
	}

	
	public abstract void testCreate();
	
	public abstract void testUpdate();
	
	public abstract void testDestroy();
	
	
	

	
}
