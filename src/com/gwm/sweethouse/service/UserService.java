package com.gwm.sweethouse.service;

import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.impl.UserDaoImpl;
import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;

public class UserService {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	public Page<User> getPage(CriteriaUser cu){
		return userDaoImpl.getPage(cu);
	}
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDaoImpl.addUser(user);
	}
	public User loginUser(String phoneNum) {
		return userDaoImpl.loginUser(phoneNum);
	}
	public String getUserPhoto(int userId) {
		// TODO Auto-generated method stub
		
		return userDaoImpl.getUserPhoto(userId);
	}
	
	
}
