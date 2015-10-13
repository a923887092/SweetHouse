package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.service.RecommendService;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class RecommendServlet extends HttpServlet {

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
	private RecommendService recommendService = new RecommendService();
	protected void getProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//productname和pageno参数在哪？
		String productnameStr = request.getParameter("productname");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println("recommend:"+ pageNoStr);
		int pageNo = 1;
		String productname = productnameStr == null ? "" : new String(productnameStr.getBytes("ISO-8859-1"), "utf-8");
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
			}
		}
		CriteriaProduct cp = new CriteriaProduct(productname, pageNo);
		Page<Recommend> page = recommendService.getPage(cp);
		request.setAttribute("RecommendPage", page);
		request.getRequestDispatcher("recommend/index.jsp").forward(request,
				response);
	}
	
	private ArrayList<Recommend> recommends;
	protected void getJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		recommends = new ArrayList<Recommend>();
		recommends = recommendService.getRecommends();
		Gson gson = new Gson();
		String json =  gson.toJson(recommends);
		response.getOutputStream().write(json.getBytes("UTF-8"));
		System.out.println(json);
		response.setContentType("text/json; charset=UTF-8");
//		return json;
	}
}
