package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;
import org.hibernate.Session;


public interface IDAO<T> {
	
	public Session getSession();
	
	public void save(T item);
	public void delete(T item);
	
	public T findByPrimaryKey(Long primaryKey);
	public List<T> findAll(T item);	
	public List<T> findByExample(T item, boolean fuzzy);
}
