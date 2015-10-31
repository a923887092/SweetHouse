package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.dao.impl.ProductDaoImpl;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;



public class ProductService {
	private ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	
	public Page<Product> getPage(CriteriaProduct cp){
		return productDaoImpl.getPage(cp);
	}
	public void addProduct(Product product) {
		productDaoImpl.add(product);
	}
	public void delete(int id) {
		productDaoImpl.delete(id);
	}
	public Product getProduct(int id) {
		return productDaoImpl.getProduct(id);
	}
	public void addProduct2(Product product) {
		productDaoImpl.add2(product);
	}
	public void update(Product product) {
		productDaoImpl.update(product);
	}
	
	public ArrayList<Product> getProductForList(int xl_id){
		return productDaoImpl.getProductForList(xl_id);
	}
	public ArrayList<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDaoImpl.getAllProduct();
		
	}
	public Page<Product> getProductPage(int id, CriteriaProduct cp) {
		// TODO Auto-generated method stub
		return productDaoImpl.getPageForXl(id, cp);
	}
	public Page<Product> getProductPage(int id, CriteriaProduct cp, int d) {
		// TODO Auto-generated method stub
		return productDaoImpl.getPageForXl(id, cp, d);
	}
	public Page<Product> getProductPage(int id, CriteriaProduct cp,
			int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return productDaoImpl.getPageForXl(id, cp, minPrice, maxPrice);
	}
}
