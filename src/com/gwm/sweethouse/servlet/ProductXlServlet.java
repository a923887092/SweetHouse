package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.service.ProductDlService;
import com.gwm.sweethouse.service.ProductXlService;
import com.gwm.sweethouse.web.CriteriaProductXl;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductXlServlet extends HttpServlet {

	private ProductXlService productXlService = new ProductXlService();
	private ProductDlService productDlService = new ProductDlService();
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
	
	protected void getProductXl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String productxlnameStr = request.getParameter("productxlname");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println("-----");
		int pageNo = 1;
		String productxlname = productxlnameStr == null ? "":(new String(productxlnameStr.getBytes("ISO-8859-1"), "utf-8"));
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {}
		}
		
		CriteriaProductXl cp = new CriteriaProductXl(productxlname, pageNo);
		System.out.println(cp);
		Page<ProductXl> page = productXlService.getPage(cp);
		
		request.setAttribute("productXlPage", page);
		request.getRequestDispatcher("./Xl/index.jsp").forward(request, response);
	}
	protected void addProductXl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentStr = request.getParameter("parent");
		parentStr = new String(parentStr.getBytes("ISO-8859-1"),"utf-8");
		System.out.println(parentStr);
		int dl_id = productDlService.getDlItem(parentStr).getDl_id();
		String categoryName = request.getParameter("categoryName");
		String productPic = request.getParameter("productPic");
		if(categoryName != "" && productPic != null){
			categoryName = new String(categoryName.getBytes("ISO-8859-1"),"utf-8");
			productPic = new String(productPic.getBytes("ISO-8859-1"),"utf-8");
			productXlService.addProductXl(categoryName, dl_id, "/image/" + productPic);
			request.getRequestDispatcher("productXlServlet?method=getProductXl").forward(request, response);
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
			productXlService.delete(id);
			request.getRequestDispatcher("productXlServlet?method=getProductXl").forward(request, response);
		} else {
			request.setAttribute("errorCode", "出现错误！！");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}
	/**
	 * 得到所有的大类
	 */
	
	protected void getAllDl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<ProductDl> list = productDlService.getAllDl();
		System.out.println(list);
		if (list != null) {
			request.setAttribute("allDl", list);
			request.getRequestDispatcher("Xl/add.jsp").forward(request, response);
		}
	}
	protected void getProductXlItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}
		if(id != 0){
			ProductXl productXl = productXlService.getProductXlItem(id);
			request.setAttribute("productXlItem", productXl);
			request.getRequestDispatcher("Xl/edit.jsp").forward(request, response);
		}
	}
	protected void getJson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dlName = request.getParameter("dlName");
		dlName = new String(dlName.getBytes("ISO-8859-1"),"utf-8");
		System.out.println("dlName:+++++"+dlName);
		ProductDl pd = productDlService.getDlItem(dlName);
		ArrayList<ProductXl> list = productXlService.getList(pd);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.getOutputStream().write(json.getBytes("UTF-8"));
		response.setContentType("text/json; charset=UTF-8");
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productPic = request.getParameter("productPic");
		String categoryName = request.getParameter("categoryName");
		String idstr = request.getParameter("categoryId");
		String parenIdstr = request.getParameter("parentId");
		int id = 0;
		int parentId = 0;
		try {
			id = Integer.parseInt(idstr);
			parentId = Integer.parseInt(parenIdstr);
		} catch (NumberFormatException e) {}
		if(id != 0 && parentId != 0){
			if(categoryName != "" && productPic != null){
				productPic = new String(productPic.getBytes("ISO-8859-1"),"utf-8");
				categoryName = new String(categoryName.getBytes("ISO-8859-1"),"utf-8");
				ProductXl px = new ProductXl(id, categoryName, parentId, productPic);
				productXlService.update(px);
				request.getRequestDispatcher("productXlServlet?method=getProductXl").forward(request, response);
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
