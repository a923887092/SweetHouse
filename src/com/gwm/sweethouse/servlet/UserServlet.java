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
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.service.UserService;
import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserServlet extends HttpServlet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	
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

	public void getUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernameStr = request.getParameter("username");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println(usernameStr);
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
	
	
	//android客户端用户注册
	protected void addUser(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String phoneNum = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		System.out.println(phoneNum+"::"+password);
		User user = new User();
		user.setUser_image(null);
		user.setUser_mobile(phoneNum);
		user.setUser_name(null);
		user.setUser_password(password);
		user.setUser_state("1");
		System.out.println(user.toString());
		userService.addUser(user);
		
	}
	//android客户端用户登录
	public void loginUser(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String phoneNum = request.getParameter("phoneNumber");
		User user = userService.loginUser(phoneNum);
		System.out.println(user.toString());
		Gson gson = new Gson();
		String jsonString = gson.toJson(user);
		System.out.println(jsonString);
        response.getWriter().print(jsonString);
	}
	
	//android客户端加载用户头像存放的路径
	public void getUserPhoto(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  String user_idString = request.getParameter("user_id");
	  int user_id = Integer.parseInt(user_idString);
	  String url =  userService.getUserPhoto(user_id);
	  System.out.println("url"+url);
	  response.setContentType("text/html;charset=UTF-8");
	  response.getWriter().print(url);  
	}
	
	
}
