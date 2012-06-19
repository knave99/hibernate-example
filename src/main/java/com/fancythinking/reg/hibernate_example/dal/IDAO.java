package com.fancythinking.reg.hibernate_example.dal;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;


public interface IDAO<T, ID extends Serializable> {
	
	public Session getSession();
	
	public void save(T item);
	public void delete(T item);
	
	public T findByPrimaryKey(ID id);
	public List<T> findAll(T item);
	public List<T> findAll(int startIndex, int endIndex);	
	public List<T> findByExample(T item, boolean fuzzy);	
	
	public void beginTransaction();
	public void commitTransaction();
	
}
