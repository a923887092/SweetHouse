package com.gwm.sweethouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gwm.sweethouse.dao.IChangeCart;
import com.gwm.sweethouse.utils.DBUTIL_1;



public class ImpChangeCart implements IChangeCart {

	public void deleteCart(int cart_id, int user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBUTIL_1.getConnection();
		String sql = "DELETE FROM user_cars WHERE car_id =? AND user_id=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCartAmount(int change, int cart_id, int user_id) {
		if(change==1|change==0){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBUTIL_1.getConnection();
		String sql = null;
		if (change==1 ) {
			sql = "UPDATE user_cars SET product_amount=product_amount+1 WHERE "
					+ "car_id=? AND user_id=?";
		} else if (change==0) {
			sql = "UPDATE user_cars SET product_amount=product_amount-1 WHERE "
					+ "car_id=? AND user_id=?";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	
}
