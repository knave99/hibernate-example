package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.bean.BinaryFile;

public class BinaryFileDAO extends DAO<BinaryFile> {

	public BinaryFile findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(BinaryFile.class, id);
	}
	
	public List<BinaryFile> findAll() {
		return super.findAll(new BinaryFile());
	}
}
