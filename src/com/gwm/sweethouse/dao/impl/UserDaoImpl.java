package com.gwm.sweethouse.dao.impl;

import java.util.List;

import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.UserDao;
import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;

public class UserDaoImpl extends BaseDao<User> implements UserDao<User>{

	public User getUser(int id) {
		String sql = "select user_id, user_name, user_password, " +
				"user_mobile, user_image, user_state from user_users " +
				"where user_id = ?";
		return query(sql, id);
	}

	public Page<User> getPage(CriteriaUser cu) {
		Page<User> page = new Page<User>(cu.getPageNo());
		page.setTotalItemNum(getTotalUserNum(cu));
		//校验pageNo是否合法
		cu.setPageNo(page.getPageNo());
		page.setList(getPageList(cu, 5));
		return page;
	}

	public long getTotalUserNum(CriteriaUser cu) {
		String sql = "select count(user_id) from user_users where user_name like ?";
		return getSingleVal(sql, cu.getUsername());
	}

	public List<User> getPageList(CriteriaUser cu, int pageSize) {
		String sql = "select * from user_users where user_name like ? limit ?, ?";
		return queryForList(sql, cu.getUsername(), 
				(cu.getPageNo() - 1) * pageSize, pageSize);
	}

	public int getState(Integer id) {
		String sql = "select user_state from user_users where uses_id = ?";
		return getSingleVal(sql, id);
	}

}
