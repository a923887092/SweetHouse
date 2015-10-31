package com.gwm.sweethouse.dao;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.web.CriteriaProductDl;
import com.gwm.sweethouse.web.CriteriaProductXl;
import com.gwm.sweethouse.web.Page;

public interface ProductXlDao<ProductXl> {
	ProductXl getProduct(int id);
	
	Page<ProductXl> getPage(CriteriaProductXl cp); 
	
	long getTotalProductNum(CriteriaProductXl cp);
	
	List<ProductXl> getPageList(CriteriaProductXl cp, int pageSize);
	
	void addProductXl(String pd, int dl_id, String xl_pic);
	
	void deleteProductXl(int id);
	
	void update(ProductXl px);
	
	List<ProductXl> getAllXl();
	
	List<ProductXl> getXlByDl(int dl_id);
	
	ArrayList<ProductXl> getXlList(ProductDl pd);
}
