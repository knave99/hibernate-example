package com.fancythinking.reg.hibernate_example.dal;

import java.util.List;

import com.fancythinking.reg.hibernate_example.bean.CarBean;

public class CarBeanDAO extends DAO<CarBean> {
	public CarBean findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(CarBean.class, id);
	}
	
	public List<CarBean> findAll() {
		return super.findAll(new CarBean());
	}
}
