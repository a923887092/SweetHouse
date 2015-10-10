package com.gwm.sweethouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gwm.sweethouse.dao.DAO;
import com.gwm.sweethouse.utils.JDBCUtils;
import com.gwm.sweethouse.utils.ReflectionUtils;





public class BaseDao<T> implements DAO<T> {

	private QueryRunner queryRunner = new QueryRunner(); 
	private Class<T> clazz;
	
	public BaseDao() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}
	
	public long insert(String sql, Object... args) {
		long id = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			//生成主键值
			preparedStatement =  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
			}
			
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JDBCUtils.connRelease(connection);
		}
		return id;
	}

	
	public void update(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.connRelease(connection);
		}
		
	}


	public T query(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.connRelease(connection);
		}
		return null;
	}

	
	public List<T> queryForList(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.connRelease(connection);
		}

		return null;
	}

	
	public <E> E getSingleVal(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.connRelease(connection);
		}

		return null;
	}

	
	public void batch(String sql, Object[]... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			queryRunner.batch(connection , sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.connRelease(connection);
		}

		
	}

}
