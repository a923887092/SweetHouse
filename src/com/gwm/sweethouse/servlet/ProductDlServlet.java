package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.service.ProductDlService;
import com.gwm.sweethouse.web.CriteriaProductDl;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductDlServlet extends HttpServlet {

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
	private ProductDlService productDlService = new ProductDlService();
	protected void getProductDl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String productdlnameStr = request.getParameter("productdlname");
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		String productdlname = productdlnameStr == null ? "":(new String(productdlnameStr.getBytes("ISO-8859-1"), "utf-8"));
		System.out.println(productdlname);
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {}
		}
		
		CriteriaProductDl cp = new CriteriaProductDl(productdlname, pageNo);
		Page<ProductDl> page = productDlService.getPage(cp);
		request.setAttribute("productDlPage", page);
		request.getRequestDispatcher("Node/index.jsp").forward(request, response);
	}
	protected void addProductDl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		System.out.println(categoryName);
		if(categoryName != ""){
			categoryName = new String(categoryName.getBytes("ISO-8859-1"),"utf-8");
			productDlService.addProductDl(categoryName);
			request.getRequestDispatcher("productDlServlet?method=getProductDl").forward(request, response);
		} else {
			request.setAttribute("errorCode", "分类名称不能为空！");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idstr);
		} catch (NumberFormatException e) {}
		if(id != 0){
			productDlService.delete(id);
			request.getRequestDispatcher("productDlServlet?method=getProductDl").forward(request, response);
		} else {
			request.setAttribute("errorCode", "出现错误！！");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		String idstr = request.getParameter("categoryId");
		int id = 0;
		try {
			id = Integer.parseInt(idstr);
		} catch (NumberFormatException e) {}
		if(id != 0){
			if(categoryName != ""){
				categoryName = new String(categoryName.getBytes("ISO-8859-1"),"utf-8");
				productDlService.update(categoryName, id);
				request.getRequestDispatcher("productDlServlet?method=getProductDl").forward(request, response);
			} else {
				request.setAttribute("errorCode", "分类名称不能为空！");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorCode", "出现错误！！");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}
}
