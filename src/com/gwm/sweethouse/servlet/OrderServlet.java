package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.Order;
import com.gwm.sweethouse.service.OrderService;
import com.gwm.sweethouse.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class OrderServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取request域中存储的method参数，由此决定调用方法
        String methodName = request.getParameter("method");
		try {
			//利用反射调用方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询订单，只查询order_price，order_price由提交订单是算出来的
	public void getAllOrders(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String user_idString = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_idString);
		Order order = new Order();
		order.setUser_id(user_id);
		List<Order> list = new ArrayList<Order>();
		list = orderService.getAllOrders(order);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		System.out.println(jsonString);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonString);
	}
	
	//按状态查询订单
	public void getOrdersByState(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		List<Order> list = new ArrayList<Order>();
		String user_idString = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_idString);
		String order_stateString = request.getParameter("order_state");
		int order_state = Integer.parseInt(order_stateString);
		Order order = new Order();
		order.setUser_id(user_id);
		order.setOrder_state(order_state);
		list = orderService.getOrdersByState(order);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().print(jsonString);
	}
}
