package com.gwm.sweethouse.service;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.dao.impl.ProductXlDaoImpl;
import com.gwm.sweethouse.web.CriteriaProductXl;
import com.gwm.sweethouse.web.Page;

public class ProductXlService {
	private ProductXlDaoImpl productXlDaoImpl = new ProductXlDaoImpl();
	
	public ProductXl getProductXlItem(int id){
		return productXlDaoImpl.getProduct(id);
	}
	public Page<ProductXl> getPage(CriteriaProductXl cp){
		return productXlDaoImpl.getPage(cp);
	}
	public void addProductXl(String pd, int dl_id, String xl_pic){
		productXlDaoImpl.addProductXl(pd, dl_id, xl_pic);
	}
	public void delete(int id){
		productXlDaoImpl.deleteProductXl(id);
	}
	public void update(ProductXl px){
		productXlDaoImpl.update(px);
	}
	
	public List<ProductXl> getAllXl(){
		return productXlDaoImpl.getAllXl();
	}
	public List<ProductXl> getXlByDl(int dl_id) {
		return productXlDaoImpl.getXlByDl(dl_id);
	}
	public ArrayList<ProductXl> getList(ProductDl pd) {
		return productXlDaoImpl.getXlList(pd);
	}
}
