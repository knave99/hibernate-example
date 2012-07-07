package com.cloudshaped.generated;

import java.util.List;

import com.fancythinking.reg.hibernate_example.dal.DAO;

public class UserbeanDAO extends DAO<Userbean> {

	public Userbean findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(Userbean.class, id);
	}
	
	public List<Userbean> findAll() {
		return super.findAll(new Userbean());
	}
}
