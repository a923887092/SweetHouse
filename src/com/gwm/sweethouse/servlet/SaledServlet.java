package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.bean.Saled;
import com.gwm.sweethouse.service.SaledService;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SaledServlet extends HttpServlet {
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
	private SaledService saledService = new SaledService();
	protected void getJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Saled> saleds = saledService.getSaledForList();
//		recommends = new ArrayList<Recommend>();
//		recommends = recommendService.getRecommends();
		Gson gson = new Gson();
		String json = gson.toJson(saleds);
		response.getOutputStream().write(json.getBytes("UTF-8"));
		System.out.println(json);
		response.setContentType("text/json; charset=UTF-8");
		// return json;
	}
	protected void getTime(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
	
		Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 20);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        long m6 = c.getTimeInMillis();
       
        System.out.println("+++" + m6);
		
		response.getOutputStream().write((m6 + "").getBytes("UTF-8"));
		// return json;
	}
}
