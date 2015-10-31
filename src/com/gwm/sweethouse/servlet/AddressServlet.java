package com.gwm.sweethouse.servlet;

import java.io.IOException;
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
import com.gwm.sweethouse.bean.Address;
import com.gwm.sweethouse.service.AddressService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class AddressServlet extends HttpServlet {

       
	private static final long serialVersionUID = 1L;

	AddressService addressService = new AddressService();
	
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
	
	//获取所有地址,已实现
	public void getAllAddress(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String user_idString = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_idString);
	    List<Address> list = new ArrayList<Address>();
	    list = addressService.getAllAddress(user_id);
	    //System.out.println(list.toString());
	    Gson gson = new Gson();
	    String jsonString = gson.toJson(list);
	   // jsonString =  new String(jsonString.getBytes("ISO-8859-1"), "utf-8");
	    System.out.println(jsonString);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().print(jsonString);
	 }
	//修改address，已实现
	//http://localhost:8080/SweetHouse/AddressServlet?method=editAddress&user_id=12358
	//&add_id=1&add_name=abc&add_phone=18051480933&add_address=qwert
	public void editAddress(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_idString = request.getParameter("user_id");
		System.out.println(user_idString);
		String add_idString = request.getParameter("add_id");
		System.out.println(add_idString);
		String add_nameString = request.getParameter("add_name");
		System.out.println(add_nameString);
		String add_phoneString = request.getParameter("add_phone");
		System.out.println(add_phoneString);
		String add_addressString = request.getParameter("add_address");
		System.out.println(add_addressString);
	    int user_id = Integer.parseInt(user_idString);
	    int add_id = Integer.parseInt(add_idString);
		Address address =  new Address();
		address.setAdd_id(add_id);
		address.setUser_id(user_id);
		address.setAdd_phone(add_phoneString);
		address.setAdd_name(add_nameString);
		address.setAdd_address(add_addressString);
		System.out.println(address.toString());
		addressService.editAddress(address);
   }
	//删除address，已实现
	public void deleteAddress(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
		 String user_idString = request.getParameter("user_id");
		 String add_idString = request.getParameter("add_id");
		 int user_id = Integer.parseInt(user_idString);
		 int add_id = Integer.parseInt(add_idString);
		 addressService.deleteAddress(user_id,add_id);
	}
	
	//新增address，已实现
	public void addAddress(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		 
		 String user_idString = request.getParameter("user_id");
		 //String add_idString = request.getParameter("add_id");
		 String add_nameString = request.getParameter("add_name");
		 String add_name = new String(add_nameString.getBytes("ISO-8859-1"), "utf-8");
		 String add_phone = request.getParameter("add_phone");
		 String add_addressString = request.getParameter("add_address");
		 String add_address =  new String(add_addressString.getBytes("ISO-8859-1"), "utf-8");
		 System.out.println("address"+add_addressString+":::"+add_address);
		 System.out.println("name"+add_nameString+":::"+add_name);
		 int user_id = Integer.parseInt(user_idString);
		 //int add_id = Integer.parseInt(add_idString);
		 Address address = new Address(add_address, 0, add_name, add_phone, user_id);
		 addressService.addAddress(address);
	}
	
	public void getAddressByAdd_id(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		String add_idString = request.getParameter("add_id");
		int add_id = Integer.parseInt(add_idString);
		Address address = new Address();
		address = addressService.getAddressByOrder_id(add_id);
		Gson gson = new Gson();
		String jsonString = gson.toJson(address);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().print(jsonString);
	}
}
