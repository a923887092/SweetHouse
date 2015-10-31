package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.MyActivity;
import com.gwm.sweethouse.service.ActivityService;
import com.gwm.sweethouse.web.Page;

public class ActivityServlet extends HttpServlet {

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
	private ActivityService activityService = new ActivityService();
	public void getActivities(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addr = request.getParameter("addr");
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			System.out.println("!!!!!!!!"+pageNo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		addr = new String(addr.getBytes("ISO-8859-1"), "utf-8");
		Page<MyActivity> page = activityService.getActivitiesForPage(addr, pageNo);
		Gson gson = new Gson();
		String json = gson.toJson(page.getList());
		System.out.println(json);
		response.getOutputStream().write(json.getBytes("UTF-8"));
		response.setContentType("text/json; charset=UTF-8");
 	}
}
