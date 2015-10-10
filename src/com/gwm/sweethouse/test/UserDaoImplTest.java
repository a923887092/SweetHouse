package com.gwm.sweethouse.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.impl.UserDaoImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDaoImplTest {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	@Test
	public void testGetUser() {
		String sql = "select user_id, user_name, user_password, " +
				"user_mobile, user_image, user_state from user_users " +
				"where user_id = ?";
		User user = userDaoImpl.query(sql, 1);
		System.out.println(user);
	}

	@Test
	public void testGetUsers() {
		String sql = "select user_id, user_name, user_password, " +
				"user_mobile, user_image, user_state from user_users ";
		List<User> list = userDaoImpl.queryForList(sql);
		System.out.println(list);
	}

	@Test
	public void testGetTotalUserNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

}
