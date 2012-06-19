package com.fancythinking.reg.hibernate_example.dal;

import com.fancythinking.reg.hibernate_example.bean.BinaryFile;

public class BinaryFileDAO extends DAO<BinaryFile, Long> implements IBinaryFileDAO {

	public BinaryFileDAO() {
		super(BinaryFile.class);
	}
}
