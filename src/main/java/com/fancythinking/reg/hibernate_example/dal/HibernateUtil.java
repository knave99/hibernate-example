package com.fancythinking.reg.hibernate_example.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.fancythinking.reg.hibernate_example.bean.BinaryFile;
import com.fancythinking.reg.hibernate_example.bean.CarBean;
import com.fancythinking.reg.hibernate_example.bean.Course;
import com.fancythinking.reg.hibernate_example.bean.NameX;
import com.fancythinking.reg.hibernate_example.bean.Student;
import com.fancythinking.reg.hibernate_example.bean.UserBean;

public class HibernateUtil {
	
	private static Class<?>[] beanList = null;				// <=== add more beans here
	private static SessionFactory factory = null;
	
	
	public static void closeSession() {
		getSession().close();
	}
	
	public static void rollBackTransaction() {
		getSession().getTransaction().rollback();
	}
	
	public static Session beginTransaction() {
		Session session = getSession();
		session.beginTransaction();
		return session;
	}
	
	public static void commitTransaction(Session session) {
		session.getTransaction().commit();
	}
	
	public static void commitTransaction() {
		getSession().getTransaction().commit();
	}
	
	public static Session getSession() {
		if ( factory == null ) {
			Configuration config = getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		return factory.getCurrentSession();
	}
	
	public static void recreateDatabase() {
		Configuration config = getInitializedConfiguration();
		new SchemaExport(config).create(true, true);
	}

	
	private static void addBeans(AnnotationConfiguration config, Class<?>[] beans) {
		for ( Class<?> c : beans ) {
			config.addAnnotatedClass(c);	
		}				
	}
	
	private static AnnotationConfiguration getInitializedConfiguration() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		addBeans(config, beanList);
		config.configure();
		return config;
	}
	public static Class<?>[] getBeanList() {
		return beanList;
	}

	public static void setBeanList(Class<?>[] beanList) {
		HibernateUtil.beanList = beanList;
	}
	
	public static void main(String[] args) {
		HibernateUtil.setBeanList( new Class[] { UserBean.class, CarBean.class, NameX.class, Student.class, Course.class, BinaryFile.class } );
		recreateDatabase();
	}
}
