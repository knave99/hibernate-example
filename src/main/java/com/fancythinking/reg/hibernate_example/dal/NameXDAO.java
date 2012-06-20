package com.fancythinking.reg.hibernate_example.dal;


import com.fancythinking.reg.hibernate_example.bean.NameX;

public class NameXDAO extends DAO<NameX, Long> implements INameXDAO {

	public NameXDAO() {
		super(NameX.class);
	}
}
