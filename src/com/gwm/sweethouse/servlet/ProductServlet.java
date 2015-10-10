package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.service.ProductDlService;
import com.gwm.sweethouse.service.ProductService;
import com.gwm.sweethouse.service.ProductXlService;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;
import com.sun.xml.internal.bind.v2.model.core.ID;


public class ProductServlet extends HttpServlet {


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

	private ProductService productService = new ProductService();
	private ProductDlService productDlService = new ProductDlService();
	private ProductXlService productXlService = new ProductXlService();
	protected void getProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//productname和pageno参数在哪？
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
		Page<Product> page = productService.getPage(cp);
		request.setAttribute("productPage", page);
		request.getRequestDispatcher("Menu/index.jsp").forward(request,
				response);
	}
	protected void getDlAndXl(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductDl> listDls = productDlService.getAllDl();
		List<ProductXl> listXls = productXlService.getAllXl();
		
		request.setAttribute("listDls", listDls);
		request.setAttribute("listXls", listXls);
		
		request.getRequestDispatcher("Menu/add.jsp").forward(request, response);
	}
	protected void getDLAndXl(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		Product product = productService.getProduct(id);
		int xl_id = product.getXl_id();
		System.out.println(xl_id);
		if (xl_id != 0) {
			ProductXl productXl = productXlService.getProductXlItem(xl_id);
			ProductDl productDl = productDlService.getDlItemById(productXl.getDl_id());
			List<ProductDl> listDls = productDlService.getAllDl();
			List<ProductXl> listXls = productXlService.getAllXl();
			
			request.setAttribute("product", product);
			request.setAttribute("productDlItem", productDl);
			request.setAttribute("productXlItem", productXl);
			request.setAttribute("listDls", listDls);
			request.setAttribute("listXls", listXls);
			request.getRequestDispatcher("Menu/edit.jsp").forward(request, response);
		}
		
	}
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {}
		if (id != 0) {
			productService.delete(id);
			request.getRequestDispatcher("ProductServlet?method=getProduct").forward(request, response);
		}
	}
	protected void addProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productXl = request.getParameter("productXl");
		String productName = request.getParameter("productName");
		if (productName != null) {
			productName = new String(productName.getBytes("ISO-8859-1"), "utf-8");
		}
		String productPriceStr = request.getParameter("productPrice");
		String commountCountStr = request.getParameter("commountCount");
		String productDisStr = request.getParameter("productDis");
		String productPic = request.getParameter("productPic");
		if (productPic != null) {
			productPic = new String(productPic.getBytes("ISO-8859-1"), "utf-8");
		}
		String productSumStr = request.getParameter("productSum");
		String productDesc = request.getParameter("productDesc");
		if (productDesc != null) {
			productDesc = new String(productDesc.getBytes("ISO-8859-1"), "utf-8");
		}
		int xl_id = 0;
		float productPrice = 0;
		int commentCount = 0;
		float productDis = 0;
		int productSum = 0;
		try {
			xl_id = Integer.parseInt(productXl);
			productPrice = Float.parseFloat(productPriceStr);
			commentCount = Integer.parseInt(commountCountStr);
			productDis = Float.parseFloat(productDisStr);
			productSum = Integer.parseInt(productSumStr);
		} catch (NumberFormatException e) {}
		if (xl_id != 0) {
			Product product = new Product(Integer.MAX_VALUE, productName, xl_id, productPrice, commentCount, productDis, productPic, productSum, productDesc);
			productService.addProduct(product);
			request.getRequestDispatcher("ProductServlet?method=getProduct").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productIdStr = request.getParameter("productId");
		int productId = Integer.parseInt(productIdStr);
		String productXl = request.getParameter("productXl");
		String productName = request.getParameter("productName");
		if (productName != null) {
			productName = new String(productName.getBytes("ISO-8859-1"), "utf-8");
		}
		String productPriceStr = request.getParameter("productPrice");
		String commountCountStr = request.getParameter("commountCount");
		String productDisStr = request.getParameter("productDis");
		String productPic = request.getParameter("productPic");
		if (productPic != null) {
			productPic = new String(productPic.getBytes("ISO-8859-1"), "utf-8");
		}
		String productSumStr = request.getParameter("productSum");
		String productDesc = request.getParameter("productDesc");
		if (productDesc != null) {
			productDesc = new String(productDesc.getBytes("ISO-8859-1"), "utf-8");
		}
		int xl_id = 0;
		float productPrice = 0;
		int commentCount = 0;
		float productDis = 0;
		int productSum = 0;
		try {
			xl_id = Integer.parseInt(productXl);
			productPrice = Float.parseFloat(productPriceStr);
			commentCount = Integer.parseInt(commountCountStr);
			productDis = Float.parseFloat(productDisStr);
			productSum = Integer.parseInt(productSumStr);
		} catch (NumberFormatException e) {}
		if (xl_id != 0) {
			Product product = new Product(productId, productName, xl_id, productPrice, commentCount, productDis, productPic, productSum, productDesc);
			productService.update(product);
			request.getRequestDispatcher("ProductServlet?method=getProduct").forward(request, response);
		}
	}

}
