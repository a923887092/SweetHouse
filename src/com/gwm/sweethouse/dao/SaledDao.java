package com.gwm.sweethouse.dao;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public interface SaledDao<Saled>{
	Saled getSaled(int id);
	Page<Saled> getPage(CriteriaProduct cp);
	long getTotalSaledNum(CriteriaProduct cp);
	
	List<Saled> getPageList(CriteriaProduct cp, int pageSize);
	
	ArrayList<Saled> getSaledList();
}
