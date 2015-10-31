package com.gwm.sweethouse.dao;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.MyActivity;
import com.gwm.sweethouse.web.CriteriaActivity;
import com.gwm.sweethouse.web.Page;

public interface ActivityDao<MyActivity> {
	MyActivity getActivity(int id);
	Page<MyActivity> getPage(CriteriaActivity ca); 
	long getTotalActivityNum(CriteriaActivity ca);
	
	List<MyActivity> getPageList(CriteriaActivity ca, int pageSize);
	
	void add(MyActivity activity);
	void add2(MyActivity activity);
	void delete(int id);
	void update(MyActivity p);
	ArrayList<MyActivity> getActivityForList(String act_addr);
	Page<MyActivity> getActivitiesForPage(String addr, int pageNo);
	long getTotalActivityNumForPage(String addr);
	List<MyActivity> getPageListForPage(String addr, int pageNo, int pageSize);
}
