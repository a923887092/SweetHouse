package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Order;
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao<User> {

	@Override
	public List<Order> getAllOrders(Order order) {

		 /*SELECT order_orders.*，product_info.*，order_address.*
		 WHERE order_orders.product_id = product_info.product_id 
		 AND order_orders.user_id = 123458 AND order_orders.add_id=order_address.add_id
		*/
		
		/* SELECT
		  order_orders.order_price,order_orders.buy_count,product_info.product_name
		  , product_info.product_desc FROM order_orders,product_info WHERE
		  order_orders.product_id = product_info.product_id AND
		  order_orders.user_id = 123458*/
		/*order_orders.order_price,order_orders.order_id,order_orders.buy_count,order_orders.pay_id,order_orders.order_state"+
		",product_info.product_name, product_info.product_photo,product_info.product_desc "*/
		
		String sql = "SELECT * "+
		"FROM order_orders,product_info" +
		" WHERE order_orders.product_id = product_info.product_id "+
		"AND order_orders.user_id = ?";
		List<Order> list = new ArrayList<Order>();
		System.out.println(order.getUser_id());
		list = queryForList(sql, order.getUser_id());
		return list;
	}

	//sql能运行并查到数据
	/*SELECT order_orders.order_price,order_orders.order_id,order_orders.buy_count,order_orders.pay_id,
	    product_info.product_name, product_info.product_photo, product_info.product_desc 
		FROM order_orders,product_info 
		WHERE order_orders.product_id = product_info.product_id 
		AND order_orders.user_id = 123458 
		AND order_state=3*/
	
	/*order_orders.order_state,order_orders.user_id,order_orders.order_price,order_orders.order_id," +
	"order_orders.buy_count,order_orders.pay_id,product_info.product_name," +
	" product_info.product_photo, product_info.product_desc
	*/
	public List<Order> getOrdersByState(Order order) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM " +
				"order_orders,product_info WHERE order_orders.product_id = " +
				"product_info.product_id AND order_orders.user_id = ? AND order_orders.order_state = ?";
		List<Order> list = new ArrayList<Order>();
		//System.out.println(userId+":::"+orderState);
		System.out.println(order.getUser_id() + "-->" + order.getOrder_state());
		list = queryForList(sql,order.getUser_id(),order.getOrder_state());
		System.out.println(list.toString());
		return list;
	}

}
