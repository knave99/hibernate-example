package com.cloudshaped.generated;

import java.util.List;


import com.fancythinking.reg.hibernate_example.dal.DAO;

public class ProductDAO extends DAO<Product> {

	public Product findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(Product.class, id);
	}
	
	public List<Product> findAll() {
		return super.findAll(new Product());
	}

}
