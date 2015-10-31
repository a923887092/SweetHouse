package com.gwm.sweethouse.dao;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public interface ProductDao<Product> {
    Product getProduct(int id);
	Page<Product> getPage(CriteriaProduct cp); 
	
	long getTotalProductNum(CriteriaProduct cp);
	long getTotalProductNumForXl(int id, CriteriaProduct cp);
	List<Product> getPageList(CriteriaProduct cp, int pageSize);
	
	void add(Product product);
	void add2(Product product);
	void delete(int id);
	void update(Product p);
	
	ArrayList<Product> getProductForList(int xl_id);
	public ArrayList<Product> getAllProduct();
	
	Page<Product> getPageForXl(int id, CriteriaProduct cp);
	
	List<Product> getPageListForXl(CriteriaProduct cp, int i, int xl_id);
	Page<Product> getPageForXl(int id, CriteriaProduct cp, int d);
	List<Product> getPageListForXl(CriteriaProduct cp, int pageSize,
			int xl_id, int d);
	
	Page<Product> getPageForXl(int id, CriteriaProduct cp, int minPrice,
			int maxPrice);
	List<Product> getPageListForXl(CriteriaProduct cp, int i, int id,
			int minPrice, int maxPrice);
}
