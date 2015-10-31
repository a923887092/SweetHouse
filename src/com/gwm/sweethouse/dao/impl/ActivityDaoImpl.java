package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.MyActivity;
import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.dao.ActivityDao;
import com.gwm.sweethouse.web.CriteriaActivity;
import com.gwm.sweethouse.web.Page;

public class ActivityDaoImpl extends BaseDao<MyActivity> implements
		ActivityDao<MyActivity> {

	@Override
	public MyActivity getActivity(int id) {
		String sql = "select * from act_info where product_id = ?";
		return query(sql, id);
	}

	@Override
	public Page<MyActivity> getPage(CriteriaActivity ca) {
		Page<MyActivity> page = new Page<MyActivity>(ca.getPageNo());
		page.setTotalItemNum(getTotalActivityNum(ca));
		//校验pageNo是否合法
		ca.setPageNo(page.getPageNo());
		page.setList(getPageList(ca, 6));
		return page;
	}

	@Override
	public long getTotalActivityNum(CriteriaActivity ca) {
		String sql = "select count(product_id) from act_info where act_title like ?";
		return getSingleVal(sql, ca.getActivityName());
	}

	@Override
	public List<MyActivity> getPageList(CriteriaActivity ca, int pageSize) {
		String sql = "select * from act_info where act_title like ? limit ?, ?";
		return queryForList(sql, ca.getActivityName(), 
				(ca.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public void add(MyActivity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add2(MyActivity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MyActivity p) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<MyActivity> getActivityForList(String act_addr) {
		String sql = "select * from act_info where act_addr = ?";
		return (ArrayList<MyActivity>) queryForList(sql, act_addr);
	}

	public Page<MyActivity> getActivitiesForPage(String addr, int pageNo) {
		Page<MyActivity> page = new Page<MyActivity>(pageNo);
		page.setTotalItemNum(getTotalActivityNumForPage(addr));
		//校验pageNo是否合法
//		ca.setPageNo(page.getPageNo());
		page.setList(getPageListForPage(addr, pageNo, 6));
		return page;
	}
	
	public long getTotalActivityNumForPage(String addr) {
		String sql = "select count(act_id) from act_info where act_addr = ?";
		return getSingleVal(sql, addr);
	}
	
	public List<MyActivity> getPageListForPage(String addr, int pageNo, int pageSize) {
		String sql = "select * from act_info where act_addr = ? limit ?, ?";
		return queryForList(sql, addr, (pageNo - 1) * pageSize, pageSize);
	}
}
