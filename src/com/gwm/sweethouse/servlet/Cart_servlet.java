package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.Cart_bean;
import com.gwm.sweethouse.dao.impl.ImpSelectCar;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Cart_servlet
 */
public class Cart_servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("user_id");
		System.out.println("user_id" + userid);
		PrintWriter printWriter = resp.getWriter();
		ImpSelectCar impSelectCar = new ImpSelectCar();
		List<Cart_bean> list = impSelectCar.selectCartBean("1");
		JSONArray jsonArray = JSONArray.fromObject(list);
		printWriter.write(jsonArray.toString());

	}

}
