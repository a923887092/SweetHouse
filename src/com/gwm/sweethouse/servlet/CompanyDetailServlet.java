package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.gwm.sweethouse.bean.CompanyDetail;
import com.gwm.sweethouse.service.CompanyDetailService;
import com.mysql.jdbc.log.Log;
public class CompanyDetailServlet extends HttpServlet {
	CompanyDetailService comDetailService=new CompanyDetailService();
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
	
	public void comDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String comid = request.getParameter("comid");
		int id = Integer.parseInt(comid);
		System.out.println(comid);
		CompanyDetail companyDetail=new CompanyDetail();
		companyDetail.setDt_id(id);
		ArrayList<CompanyDetail> list=comDetailService.detail(companyDetail);
		Gson gson = new Gson();
	    String jsonString = gson.toJson(list);
		System.out.println(list);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(jsonString);
	}

}
