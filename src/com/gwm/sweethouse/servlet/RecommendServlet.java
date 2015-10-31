package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.service.ProductService;
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
	private ProductService productService = new ProductService();

	protected void getRecommendProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// productname和pageno参数在哪？
		String productnameStr = request.getParameter("productname");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println("recommend:" + pageNoStr);
		int pageNo = 1;
		String productname = productnameStr == null ? "" : new String(
				productnameStr.getBytes("ISO-8859-1"), "utf-8");
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


	protected void getProductAndUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);

		Recommend recommend = recommendService.getRecommend(id);
		ArrayList<Product> products = productService.getAllProduct();
		request.setAttribute("recommend", recommend);
		request.setAttribute("products", products);
		request.getRequestDispatcher("recommend/edit.jsp")
				.forward(request, response);
	}

	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String recIdStr = request.getParameter("recId");
		String productIdStr = request.getParameter("product_id");
		int recId = Integer.parseInt(recIdStr);
		int productId = Integer.parseInt(productIdStr);
		
		recommendService.update(recId, productId);
		request.getRequestDispatcher("recommendServlet?method=getRecommendProduct").forward(request, response);
	}
	private ArrayList<Recommend> recommends;

	protected void getJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productnameStr = request.getParameter("productname");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println(pageNoStr);
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
//		recommends = new ArrayList<Recommend>();
//		recommends = recommendService.getRecommends();
		Gson gson = new Gson();
		String json = gson.toJson(page.getList());
		response.getOutputStream().write(json.getBytes("UTF-8"));
		System.out.println(json);
		response.setContentType("text/json; charset=UTF-8");
		// return json;
	}
}
