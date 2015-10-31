package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.DesOrder;
import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.service.DesOrderService;

public class DesOrderServlet extends HttpServlet {
		DesOrderService desOrderServlet=new DesOrderService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
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
	public void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*String idString = request.getParameter("id");*/
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String userName = request.getParameter("orderName");
		String comIdString=request.getParameter("comId");
		String orderTime=request.getParameter("orderTime");
		/*int id = Integer.parseInt(idString);*/
		int comId=Integer.parseInt(comIdString);
		
		DesOrder desorder=new DesOrder();
		/*desorder.setOrd_id(id);*/
		desorder.setCom_id(comId);
		desorder.setOrd_addr(addr);
		desorder.setOrd_orderTime(orderTime);
		desorder.setOrd_userName(userName);
		desorder.setOrd_tel(tel);
	    desOrderServlet.addOrder(desorder);
	}
	
}
