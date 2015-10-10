package com.gwm.sweethouse.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gwm.sweethouse.dao.impl.Impselectuser;
import com.gwm.sweethouse.utils.MD5Utils;

public class Checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String uname = request.getParameter("username");
		String upass = request.getParameter("password");
		String md5upass=MD5Utils.md5Password(upass);
		// 用户输入的验证码
		String verifyCode = request.getParameter("verifyCode");
		// 生成的验证码值
		String session_vcode = (String) session.getAttribute("session_vcode");
		Impselectuser impselectuser = new Impselectuser();
		boolean check = impselectuser.selectuser(uname, md5upass);

		if (check) {
			if (verifyCode.equalsIgnoreCase(session_vcode)) {
				request.getSession().setAttribute("username", uname);
				session.setMaxInactiveInterval(60 * 20);
				Cookie cookie = new Cookie("seid", session.getId());
				cookie.setMaxAge(60 * 60);
				response.addCookie(cookie);
				response.sendRedirect("./index.jsp");
			} else {
				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}

		} else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

}
