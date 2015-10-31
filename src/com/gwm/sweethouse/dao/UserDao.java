package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;

public interface UserDao<User> {
	User getUser(int id);
	
	Page<User> getPage(CriteriaUser cu); 
	
	long getTotalUserNum(CriteriaUser cu);
	
	List<User> getPageList(CriteriaUser cu, int pageSize);
	
	int getState(Integer id);
	
	public String getUserPhoto(int userId);

}
