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
import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductImg;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.service.ProductDlService;
import com.gwm.sweethouse.service.ProductImgService;
import com.gwm.sweethouse.service.ProductService;
import com.gwm.sweethouse.service.ProductXlService;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
		// productname和pageno参数在哪？
		String productnameStr = request.getParameter("productname");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println(pageNoStr);
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
		Page<Product> page = productService.getPage(cp);
		request.setAttribute("productPage", page);
		request.getRequestDispatcher("Menu/index.jsp").forward(request,
				response);
	}

	protected void getJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("xlId");
		String pageNoStr = request.getParameter("pageNo");
		String productnameStr = request.getParameter("productname");
		String priceOrderIdStr = request.getParameter("priceOrderId");
		String priceScreenIdStr = request.getParameter("priceScreenId");
		String salesIdStr = request.getParameter("salesId");
		String productname = productnameStr == null ? "" : new String(
				productnameStr.getBytes("ISO-8859-1"), "utf-8");
		int id = 0;
		int pageNo = 1;
		int priceOrderId = 0;
		int priceScreenId = 3;
		int salesId = 51;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			id = Integer.parseInt(idString);
			priceOrderId = Integer.parseInt(priceOrderIdStr);
			priceScreenId = Integer.parseInt(priceScreenIdStr);
			salesId = Integer.parseInt(salesIdStr);
			System.out.println("!!!!!!!!" + pageNo + "!!!!!!!!!" + id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		CriteriaProduct cp = new CriteriaProduct(productname, pageNo);
		if (id != 0) {
			Page<Product> page = null;
			if (priceOrderId != 0) {
				page = productService.getProductPage(id, cp, priceOrderId);
			} else if (priceScreenId != 8) {
				int minPrice = 0;
				int maxPrice = Integer.MAX_VALUE;
				switch (priceScreenId) {
				case 3:
					minPrice = 0;
					maxPrice = 200;
					break;
				case 4:
					minPrice = 200;
					maxPrice = 400;
					break;
				case 5:
					minPrice = 400;
					maxPrice = 800;
					break;
				case 6:
					minPrice = 800;
					maxPrice = 1200;
					break;
				case 7:
					minPrice = 1200;
					maxPrice = Integer.MAX_VALUE;
					break;
				} 
				page = productService.getProductPage(id, cp, minPrice, maxPrice);
			} else if (salesId != 51) {
				page = productService.getProductPage(id, cp, salesId);
			} else {
				page = productService.getProductPage(id, cp);
			}
			Gson gson = new Gson();
			String json = gson.toJson(page.getList());
			System.out.println(json);
			response.getOutputStream().write(json.getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8");
		}
	}

	protected void getProductJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idString);
			System.out.println("!!!!!!!!!!!!!!!!!" + id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (id != 0) {
			Product product = productService.getProduct(id);
			ArrayList<Product> products = new ArrayList<Product>();
			products.add(product);
			Gson gson = new Gson();
			String json = gson.toJson(products);
			System.out.println(json);
			response.getOutputStream().write(json.getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8");
		}
	}

	protected void getJsonForSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		String productnameStr = request.getParameter("productName");
		String productname = productnameStr == null ? "" : new String(
				productnameStr.getBytes("ISO-8859-1"), "utf-8");
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			System.out.println("!!!!!!!!" + pageNo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		CriteriaProduct cp = new CriteriaProduct(productname, pageNo);

		Page<Product> page = productService.getPage(cp);
		Gson gson = new Gson();
		String json = gson.toJson(page.getList());
		System.out.println(json + "1111");
		response.getOutputStream().write(json.getBytes("UTF-8"));
		response.setContentType("text/json; charset=UTF-8");
	}

	ProductImgService productImgService = new ProductImgService();

	protected void getProductImgJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idString);
			System.out.println("!!!!!!!!!!!!!!!!!" + id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (id != 0) {
			ArrayList<ProductImg> productImgs = productImgService
					.getProductImg(id);
			Gson gson = new Gson();
			String json = gson.toJson(productImgs);
			System.out.println(json);
			response.getOutputStream().write(json.getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8");
		}
	}

	protected void getDlAndXlAndAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductDl> listDls = productDlService.getAllDl();
		List<ProductXl> listXls = productXlService.getAllXl();

		request.setAttribute("listDls", listDls);
		request.setAttribute("listXls", listXls);

		request.getRequestDispatcher("Menu/add.jsp").forward(request, response);
	}

	protected void getDlAndXlAndUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);

		Product product = productService.getProduct(id);
		int xl_id = product.getXl_id();
		System.out.println(xl_id);
		if (xl_id != 0) {
			ProductXl productXl = productXlService.getProductXlItem(xl_id);
			ProductDl productDl = productDlService.getDlItemById(productXl
					.getDl_id());
			List<ProductDl> listDls = productDlService.getAllDl();
			List<ProductXl> listXls = productXlService.getAllXl();

			request.setAttribute("product", product);
			request.setAttribute("productDlItem", productDl);
			request.setAttribute("productXlItem", productXl);
			request.setAttribute("listDls", listDls);
			request.setAttribute("listXls", listXls);
			request.getRequestDispatcher("Menu/edit.jsp").forward(request,
					response);
		}

	}

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
		}
		if (id != 0) {
			productService.delete(id);
			request.getRequestDispatcher("ProductServlet?method=getProduct")
					.forward(request, response);
		}
	}

	protected void addProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productXl = request.getParameter("productXl");
		String productName = request.getParameter("productName");
		if (productName != null) {
			productName = new String(productName.getBytes("ISO-8859-1"),
					"utf-8");
		}
		String productPriceStr = request.getParameter("productPrice");
		String commountCountStr = request.getParameter("commountCount");
		String productDisStr = request.getParameter("productDis");
		String productPic = request.getParameter("productPic");
		String saledNumStr = request.getParameter("saledNum");
		if (productPic != null) {
			productPic = new String(productPic.getBytes("ISO-8859-1"), "utf-8");
		}
		String productSumStr = request.getParameter("productSum");
		String productDesc = request.getParameter("productDesc");
		if (productDesc != null) {
			productDesc = new String(productDesc.getBytes("ISO-8859-1"),
					"utf-8");
		}
		int xl_id = 0;
		float productPrice = 0;
		int commentCount = 0;
		float productDis = 0;
		int productSum = 0;
		int saledNum = 0;
		try {
			xl_id = Integer.parseInt(productXl);
			productPrice = Float.parseFloat(productPriceStr);
			commentCount = Integer.parseInt(commountCountStr);
			productDis = Float.parseFloat(productDisStr);
			productSum = Integer.parseInt(productSumStr);
			saledNum = Integer.parseInt(saledNumStr);
		} catch (NumberFormatException e) {
		}
		if (xl_id != 0) {
			Product product = new Product(Integer.MAX_VALUE, productName,
					xl_id, productPrice, commentCount, productDis, productPic,
					productSum, productDesc, saledNum);
			productService.addProduct(product);
			request.getRequestDispatcher("ProductServlet?method=getProduct")
					.forward(request, response);
		}
	}

	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productIdStr = request.getParameter("productId");
		System.out.println("productIdStr:" + productIdStr);
		int productId = Integer.parseInt(productIdStr);
		String productXl = request.getParameter("productXl");
		String productName = request.getParameter("productName");
		if (productName != null) {
			productName = new String(productName.getBytes("ISO-8859-1"),
					"utf-8");
		}
		String productPriceStr = request.getParameter("productPrice");
		String commountCountStr = request.getParameter("commountCount");
		String productDisStr = request.getParameter("productDis");
		String productPic = request.getParameter("productPic");
		String saledNumStr = request.getParameter("saledNum");
		if (productPic != null) {
			productPic = new String(productPic.getBytes("ISO-8859-1"), "utf-8");
		}
		String productSumStr = request.getParameter("productSum");
		String productDesc = request.getParameter("productDesc");
		if (productDesc != null) {
			productDesc = new String(productDesc.getBytes("ISO-8859-1"),
					"utf-8");
		}
		int xl_id = 0;
		float productPrice = 0;
		int commentCount = 0;
		float productDis = 0;
		int productSum = 0;
		int saledNum = 0;
		try {
			xl_id = Integer.parseInt(productXl);
			productPrice = Float.parseFloat(productPriceStr);
			commentCount = Integer.parseInt(commountCountStr);
			productDis = Float.parseFloat(productDisStr);
			productSum = Integer.parseInt(productSumStr);
			saledNum = Integer.parseInt(saledNumStr);
		} catch (NumberFormatException e) {
		}
		if (xl_id != 0) {
			Product product = new Product(productId, productName, xl_id,
					productPrice, commentCount, productDis, productPic,
					productSum, productDesc, saledNum);
			productService.update(product);
			request.getRequestDispatcher("ProductServlet?method=getProduct")
					.forward(request, response);
		}
	}

}
