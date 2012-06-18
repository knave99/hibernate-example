package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.bean.NameX;

public class NameXDAO extends DAO<NameX> {
	public NameX findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(NameX.class, id);
	}
	
	public List<NameX> findAll() {
		return super.findAll(new NameX());
	}
}
