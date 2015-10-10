package com.gwm.sweethouse.service;

import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.dao.impl.ProductDlDaoImpl;
import com.gwm.sweethouse.web.CriteriaProductDl;
import com.gwm.sweethouse.web.Page;

public class ProductDlService {
	private ProductDlDaoImpl productDlDaoImpl = new ProductDlDaoImpl();
	public Page<ProductDl> getPage(CriteriaProductDl cp){
		return productDlDaoImpl.getPage(cp);
	}
	public void addProductDl(String pd){
		productDlDaoImpl.addProductDl(pd);
	}
	public void delete(int id){
		productDlDaoImpl.deleteProductDl(id);
	}
	public void update(String name, int id) {
		productDlDaoImpl.updateProductDl(name, id);
	}
	public List<ProductDl> getAllDl() {
		return productDlDaoImpl.getAllDl();
	}
	public ProductDl getDlItem(String name) {
		return productDlDaoImpl.getProduct(name);
	}
	public ProductDl getDlItemById(int dl_id) {
		return productDlDaoImpl.getProduct(dl_id);
		
	}
}
