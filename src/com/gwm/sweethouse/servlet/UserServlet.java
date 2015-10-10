package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.service.UserService;
import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		
		try {
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
	private UserService userService = new UserService();
	public void getUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernameStr = request.getParameter("username");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println(pageNoStr);
		int pageNo = 1;
		String username = usernameStr == null ? "":usernameStr;
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {}
		}
		CriteriaUser cu = new CriteriaUser(username, pageNo);
		Page<User> page = userService.getPage(cu);
		request.setAttribute("userPage", page);
		request.getRequestDispatcher("User/index.jsp").forward(request, response);
 	}
}
