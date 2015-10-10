package com.gwm.sweethouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gwm.sweethouse.utils.JDBCUtils;

public class Impselectuser implements com.gwm.sweethouse.dao.Iselectuser{
	boolean judge=false;
	private Connection connection = null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	public Boolean selectuser(String username,String password) {
		try {
			connection  = JDBCUtils.getConnection();		
			//判断用户
			String sqlString="select upass from user where uname=? limit 1";
			preparedStatement=connection .prepareStatement(sqlString);
			preparedStatement.setString(1, username);
			resultSet=preparedStatement.executeQuery();
			//判断用户名是否在数据库中存在
			if (resultSet!=null) {
				//判断密码是否与相应的用户名匹配
				while(resultSet.next()){
					String password2=resultSet.getString(1);
					if (password2.equals(password)) {
						judge=true;
					}else {
						judge=false;
					}
					
				}
				
			}else {
				//数据库中不存在该用户名
				judge=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtils.connRelease(resultSet, preparedStatement, connection);
		}
		return judge;
	}
	
}
