package com.cloudshaped.generated;

import java.util.List;


import com.fancythinking.reg.hibernate_example.dal.DAO;

public class ServiceDAO extends DAO<Service> {

	public Service findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(Service.class, id);
	}
	
	public List<Service> findAll() {
		return super.findAll(new Service());
	}

}
