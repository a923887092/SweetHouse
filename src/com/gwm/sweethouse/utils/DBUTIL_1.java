package com.gwm.sweethouse.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUTIL_1 {
	public static String URL = "jdbc:mysql://localhost:3306/sweethouse";
	public static String USERNAME = "root";
	public static String PASSWORD = "123";
	public static String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void release(ResultSet resultSet,
			PreparedStatement preparedStatement, Connection connection) throws SQLException {
		if (resultSet!=null) {
			resultSet.close();
		}
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
	public static void release(
			PreparedStatement preparedStatement, Connection connection) throws SQLException {
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
}
