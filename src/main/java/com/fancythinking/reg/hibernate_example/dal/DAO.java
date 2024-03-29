package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public abstract class DAO<T> implements IDAO<T> {
	
	
	protected Logger logger = Logger.getLogger(getClass());

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
	
	public T findByPrimaryKey(Class<T> c, Long primaryKey) {
		
		Session session = getSession();
		@SuppressWarnings("unchecked")
		T item = (T) session.get(c, primaryKey);
		return item;
	}
	
	public List<T> findAll(T item) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(item.getClass());
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) criteria.list();
		return  list;		
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
