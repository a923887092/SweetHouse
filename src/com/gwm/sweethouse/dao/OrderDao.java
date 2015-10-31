package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.bean.Order;

public interface OrderDao<User> {
	
	public List<Order> getAllOrders(Order order);
}
