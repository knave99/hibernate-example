package com.fancythinking.reg.hibernate_example.dal;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public abstract class DAO<T, ID extends Serializable> implements IDAO<T, ID> {
	
	
	protected Logger logger = Logger.getLogger(getClass());
	private Class<T> persistentClass;
	
	public DAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	

	public void beginTransaction() {
		HibernateUtil.beginTransaction();
	}

	public void commitTransaction() {
		HibernateUtil.commitTransaction();		
	}


	public Session getSession() {
		return HibernateUtil.getSession();
	}
	
	public void save(T item) {
		if ( item == null ) {
			logger.error("Cannot save null");
		} else {
			getSession().saveOrUpdate(item);
		}
	}
	
	public void delete(T item) {
		getSession().delete(item);
	}
	
	public T findByPrimaryKey(Class<T> c, Serializable primaryKey) {
		
		Session session = getSession();
		@SuppressWarnings("unchecked")
		T item = (T) session.get(c, primaryKey);
		return item;
	}
 	
	public T findByPrimaryKey(ID id) {				
		@SuppressWarnings("unchecked")
		T item = (T) getSession().get(persistentClass, id);
		return item;
	}
	
	public List<T> findAll(T item) {
		Criteria criteria = getSession().createCriteria(item.getClass());
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) criteria.list();
		return  list;		
	}
		
	@SuppressWarnings("unchecked")
	public List<T> findAll(int startIndex, int fetchSize) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		criteria.setFirstResult(startIndex);
		criteria.setFetchSize(fetchSize);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T item, boolean fuzzy) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(item.getClass());
		Example example = Example.create(item);
		if ( fuzzy ) {
			example.enableLike(MatchMode.ANYWHERE);
			example.ignoreCase();
			example.excludeZeroes();			
		}
		criteria.add(example);
		
		List<T> list = (List<T>) criteria.list();
		return  list;
		
	}
}
