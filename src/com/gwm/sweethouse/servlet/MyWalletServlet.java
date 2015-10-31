package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.Wallet;
import com.gwm.sweethouse.service.MyWalletService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MyWalletServlet extends HttpServlet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	MyWalletService myWalletService = new MyWalletService();
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
	
	public void getBalanceByUserId(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Wallet wallet = new Wallet();
		String user_idString = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_idString);
		wallet = myWalletService.getBalanceByUserId(user_id);
		Gson gson = new Gson();
		String jsonString = gson.toJson(wallet);
		response.getWriter().print(jsonString);
	}

}
