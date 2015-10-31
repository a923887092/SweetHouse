package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.dao.impl.ImpChangeCart;



public class ChangeCart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String cart_id = request.getParameter("cart_id");
		String change = request.getParameter("change");
		System.out.println("change"+change+"user_id"+user_id+"cart_id"+cart_id);
		ImpChangeCart impChangeCart = new ImpChangeCart();
		if (user_id != null && cart_id != null) {
			if (change != null) {
				impChangeCart.updateCartAmount(Integer.parseInt(change),
						Integer.parseInt(cart_id), Integer.parseInt(user_id));
			} else {
				impChangeCart.deleteCart(Integer.parseInt(cart_id),
						Integer.parseInt(user_id));
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
