package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.dao.impl.ProductDaoImpl;
import com.gwm.sweethouse.dao.impl.RecommendDaoImpl;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;



public class RecommendService {
	private RecommendDaoImpl recommendDaoImpl = new RecommendDaoImpl();
	
	public Page<Recommend> getPage(CriteriaProduct cp){
		return recommendDaoImpl.getPage(cp);
	}
	/*public void addProduct(Product product) {
		recommendDaoImpl.add(product);
	}
	public void delete(int id) {
		recommendDaoImpl.delete(id);
	}*/
	public Recommend getProduct(int id) {
		return recommendDaoImpl.getReconmmend(id);
	}
	
	public ArrayList<Recommend> getRecommends(){
		return recommendDaoImpl.getRecommendList();
	}
	/*public void addProduct2(Product product) {
		recommendDaoImpl.add2(product);
	}
	public void update(Product product) {
		recommendDaoImpl.update(product);
	}*/
	public Recommend getRecommend(int id) {
		// TODO Auto-generated method stub
		return recommendDaoImpl.getReconmmend(id);
	}
	public void update(int recId, int productId) {
		// TODO Auto-generated method stub
		recommendDaoImpl.update(recId, productId);
	}
}
