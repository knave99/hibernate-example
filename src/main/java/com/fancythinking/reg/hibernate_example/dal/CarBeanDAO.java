package com.fancythinking.reg.hibernate_example.dal;

import com.fancythinking.reg.hibernate_example.bean.CarBean;

public class CarBeanDAO extends DAO<CarBean, Long> implements ICarBeanDAO {

	public CarBeanDAO() {
		super(CarBean.class);
	}

}
