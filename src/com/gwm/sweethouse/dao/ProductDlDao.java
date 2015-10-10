package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.web.CriteriaProductDl;
import com.gwm.sweethouse.web.Page;

public interface ProductDlDao {
	ProductDl getProduct(int id);
	
	ProductDl getProduct(String name);
	
	Page<ProductDl> getPage(CriteriaProductDl cp); 
	
	long getTotalProductNum(CriteriaProductDl cp);
	
	List<ProductDl> getPageList(CriteriaProductDl cp, int pageSize);
	
	void addProductDl(String pd);
	
	void deleteProductDl(int id);
	
	void updateProductDl(String name, int id);
	
	List<ProductDl> getAllDl();
}
