package com.gwm.sweethouse.dao;

import java.sql.ResultSet;
import java.util.List;
import com.gwm.sweethouse.bean.Cart_bean;

public interface ISelectCar {
	public abstract ResultSet selectCartBean();
	public abstract List<Cart_bean> selectCartBean(String user_id);

}
