package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public interface ProductDao<Product> {
    Product getProduct(int id);
	
	Page<Product> getPage(CriteriaProduct cp); 
	
	long getTotalProductNum(CriteriaProduct cp);
	
	List<Product> getPageList(CriteriaProduct cp, int pageSize);
	
	void add(Product product);
	void add2(Product product);
	void delete(int id);
	void update(Product p);
}
