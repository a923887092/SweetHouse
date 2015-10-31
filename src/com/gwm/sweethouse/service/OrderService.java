package com.gwm.sweethouse.service;

import java.util.List;

import com.gwm.sweethouse.bean.Order;
import com.gwm.sweethouse.dao.impl.OrderDaoImpl;


public class OrderService {
   private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
	public List<Order>  getAllOrders(Order order) {
		return orderDaoImpl.getAllOrders(order);
	}
	
	public List<Order> getOrdersByState(Order order) {
		// TODO Auto-generated method stub
		return orderDaoImpl.getOrdersByState(order);
	}
	

}
