package com.gwm.sweethouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gwm.sweethouse.bean.AdressBean;
import com.gwm.sweethouse.dao.ISelectAdress;
import com.gwm.sweethouse.utils.DBUTIL_1;



public class ImpSelectAdress implements ISelectAdress {

	public AdressBean selectAdress(int user_id) {
		AdressBean adressBean=null;
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUTIL_1.getConnection();
		String sql="SELECT add_address,add_phone,add_name FROM order_address WHERE user_id=? AND order_address.`add_state`=1;";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				String add_address=resultSet.getString(1);
				String add_phone=resultSet.getString(2);
				String add_name=resultSet.getString(3);
				adressBean =new AdressBean(add_phone, add_address, add_name);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adressBean;
	}

	public List<AdressBean> selectAdressList() {

		return null;
	}

}
