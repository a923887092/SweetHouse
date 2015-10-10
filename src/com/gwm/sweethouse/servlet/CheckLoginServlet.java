package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gwm.sweethouse.bean.AdminUser;

public class CheckLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		HttpSession session=request.getSession();
		String number = (String) session.getAttribute("number");
		if (verify.equals(number)) {
			if (username.equals("geweimin") && password.equals("itboy")) {
				AdminUser adminUser = new AdminUser(username, password);
				Cookie cookie = new Cookie("isLogin", "yes");
				request.setAttribute("user", adminUser);
				response.addCookie(cookie);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("errorCode", "用户名或密码错误！！");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorCode", "验证码错误！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
