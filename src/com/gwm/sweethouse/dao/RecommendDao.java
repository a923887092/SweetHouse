package com.gwm.sweethouse.dao;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public interface RecommendDao<Reconmmend> {
	Reconmmend getReconmmend(int id);
	
	Page<Reconmmend> getPage(CriteriaProduct cp); 
	
	long getTotalReconmmendNum(CriteriaProduct cp);
	
	List<Reconmmend> getPageList(CriteriaProduct cp, int pageSize);
	
	ArrayList<Recommend> getRecommendList();
//	void add(Reconmmend reconmmend);
//	void add2(Reconmmend reconmmend);
//	void delete(int id);
//	void update(Reconmmend p);
}
