package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.MyActivity;
import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.dao.impl.ActivityDaoImpl;
import com.gwm.sweethouse.dao.impl.ProductDaoImpl;
import com.gwm.sweethouse.dao.impl.RecommendDaoImpl;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;



public class ActivityService {
	ActivityDaoImpl activityDaoImpl = new ActivityDaoImpl();
	public ArrayList<MyActivity> getActivities(String act_addr){
		return activityDaoImpl.getActivityForList(act_addr);
	}
	public Page<MyActivity> getActivitiesForPage(String addr,
			int pageNo) {
		// TODO Auto-generated method stub
		return activityDaoImpl.getActivitiesForPage(addr, pageNo);
	}
}
