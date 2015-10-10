package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.service.ProductXlService;

public class SelectChangeServlet extends HttpServlet {
	private String productDl = null;
	private ProductXl productXl = null;
	private List<ProductXl> allProductXls = null;
	private ProductXlService productXlService = new ProductXlService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		productDl = request.getParameter("productDl");
		int dl_id = 0;
		try {
			dl_id = Integer.parseInt(productDl);
		} catch (NumberFormatException e) {}
		if (dl_id != 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); 
			allProductXls = productXlService.getXlByDl(dl_id);
			out.println("document.getElementById('productXl').length = " + allProductXls.size());  
		    out.println("document.getElementById('productXl').selectedIndex = 0");
		    for(int i=0; i< allProductXls.size(); i++) {  
		    	productXl = allProductXls.get(i);  
	            out.println("document.getElementById('productXl').options[" + i + "].value = '" + productXl.getXl_id() + "'");  
	            out.println("document.getElementById('productXl').options[" + i + "].text = '" + productXl.getXl_name() + "'");  
	        }
		}
	}

}
