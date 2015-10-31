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
	import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.bean.ZxCompany;
import com.gwm.sweethouse.service.ZZXOrderService;
import com.gwm.sweethouse.service.ZxCompanyService;
import com.sun.org.apache.bcel.internal.generic.NEW;

	public class ZxCompanyServlet extends HttpServlet {
		ZxCompanyService zxCompanyService=new ZxCompanyService();

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
		//价格由高到低
		public void descSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			ArrayList<ZxCompany> list = zxCompanyService.sortDesc();
			  Gson gson = new Gson();
			  String jsonString = gson.toJson(list);
			  System.out.println(list);
			  response.getWriter().print(jsonString);
		}
		
		
		
		
		//价格排序由低到高--访问路径不带参数
		public void searchSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//			String price = request.getParameter("price");
//			price = new String(price.getBytes("ISO-8859-1"),"utf-8");
//			System.out.println(price);
//			ZxCompany zxCompany=new ZxCompany();
//			zxCompany.setZx_comaprice(price);
			ArrayList<ZxCompany> list = zxCompanyService.sortAsc();
			  Gson gson = new Gson();
			  String jsonString = gson.toJson(list);
			  System.out.println(list);
			  response.getWriter().print(jsonString);
		}
		
		
		
		//装修类型
		public void searchStyle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String style = request.getParameter("style");
			style = new String(style.getBytes("ISO-8859-1"),"utf-8");
			System.out.println(style);
			ZxCompany zxCompany=new ZxCompany();
			zxCompany.setZx_comstyle(style);
			ArrayList<ZxCompany> list = zxCompanyService.style(zxCompany);
			  Gson gson = new Gson();
			  String jsonString = gson.toJson(list);
			  System.out.println(list);
			  response.getWriter().print(jsonString);
		}
		
		
		//同城装修公司
		public void searchCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String addr = request.getParameter("addr");
			addr = new String(addr.getBytes("ISO-8859-1"),"utf-8");
			System.out.println(addr);
			ZxCompany zxCompany=new ZxCompany();
			zxCompany.setZx_comaddr(addr);
			ArrayList<ZxCompany> list = zxCompanyService.city(zxCompany);
			  Gson gson = new Gson();
			  String jsonString = gson.toJson(list);
			  System.out.println(list);
			  response.setContentType("text/json;charset=utf-8");
			  response.getWriter().print(jsonString);
		}
		//搜索装修公司
		public void searchCompany(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//String idString = request.getParameter("id");
			String nameStr= request.getParameter("name");
			String name = nameStr == null ? "" : new String(nameStr.getBytes("ISO-8859-1"),"utf-8");
			System.out.println(name);
//			String logo = request.getParameter("logo");
//			String price = request.getParameter("price");
//			String example = request.getParameter("example");
//			String designer = request.getParameter("designer");
//			String addr = request.getParameter("addr");
//			String style = request.getParameter("style");
//			int id = Integer.parseInt(idString);
		   ZxCompany zxCompany=new ZxCompany();
		   //zxCompany.setZx_comid(id);
		   zxCompany.setZx_comName(name);
//		   zxCompany.setZx_comlog(logo);
//		   zxCompany.setZx_comaprice(price);
//		   zxCompany.setZx_comexample(example);
//		   zxCompany.setZx_comdesigner(designer);
//		   zxCompany.setZx_comaddr(addr);
//		   zxCompany.setZx_comstyle(style);
		   
		   ArrayList<ZxCompany> list = zxCompanyService.search(zxCompany);
		   Gson gson = new Gson();
		   String jsonString = gson.toJson(list);
		   System.out.println(list);
		   response.setContentType("text/json;charset=utf-8");
		   response.getWriter().print(jsonString);
		   
		}

	}


