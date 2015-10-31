package com.gwm.sweethouse.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwm.sweethouse.bean.Advice;
import com.gwm.sweethouse.service.AdviceService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class AdviceServlet extends HttpServlet implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdviceService  adviceService = new AdviceService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取request域中存储的method参数，由此决定调用方法
        String methodName = request.getParameter("method");
		try {
			//利用反射调用方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
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
	//http://localhost:8080/SweetHouse/AdviceServlet?method=addAdvice&user_id=123458&advice_type=86&contact_type=15555555555
	//添加意见反馈
	public void addAdvice(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_idString  = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_idString);
		String advice_type= request.getParameter("advice_type");
		String advice_content = request.getParameter("advice_content");
		System.out.println(advice_type+":::"+advice_content);
		//联系方式
		String contact_type = request.getParameter("contact_type");
	    if (contact_type == null) {
			contact_type = "保密";
		}
	    Advice advice = new Advice();
	    advice.setUser_id(user_id);
	    advice.setAdvice_type(advice_type);
	    advice.setAdvice_content(advice_content);
	    advice.setContact_type(contact_type);
	    
	    adviceService.addAdvice(advice);
	}
}
