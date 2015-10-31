package com.gwm.sweethouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Cart_bean;
import com.gwm.sweethouse.dao.ISelectCar;
import com.gwm.sweethouse.utils.DBUTIL_1;


public class ImpSelectCar implements ISelectCar {

	public ResultSet selectCartBean() {

		return null;
	}

	public List<Cart_bean> selectCartBean(String user_id) {

		List<Cart_bean> list = new ArrayList<Cart_bean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUTIL_1.getConnection();
		String sql = "SELECT product_info.`product_info`,"
				+ "product_info.`product_photo`,"
				+ "product_info.`product_price`,"
				+ "user_cars.`product_amount`," +
				"product_info.`xl_id`, user_cars.`car_id` FROM product_info,user_cars " +
				"WHERE product_info.`product_id` IN " +
				"(SELECT product_id FROM user_cars WHERE user_id=?)" +
				"AND user_cars.`product_id`=product_info.`product_id`" +
				"AND user_cars.`user_id`=?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_id);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				String goodsDescribe = resultSet.getString(1);

				int price = resultSet.getInt(3);
				String xl_id = resultSet.getString(5);
				int goods_amount = resultSet.getInt(4);
				String imagesrc = resultSet.getString(2);
				int cart_id=resultSet.getInt(6);
				String goodsname=getCategoryName(xl_id);
				Cart_bean cart_bean = new Cart_bean(goods_amount, goodsname,
						goodsDescribe, imagesrc, price,cart_id);


				list.add(cart_bean);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(i);
		
		return list;
	}

	private String getCategoryName(String xl_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String categoryname=null;
		connection = DBUTIL_1.getConnection();
		String sql = "SELECT product_xl.`xl_name`,product_dl.`dl_name` FROM product_dl,product_xl WHERE product_dl.`dl_id`=product_xl.`dl_id`AND product_xl.`xl_id`=?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, xl_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					String xl_name=resultSet.getString(1);
					categoryname=resultSet.getString(1)+"  "+resultSet.getString(2);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryname;
	}

}
