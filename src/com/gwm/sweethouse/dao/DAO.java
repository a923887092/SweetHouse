package com.gwm.sweethouse.dao;

import java.util.List;

public interface DAO<T> {
	/**
	 * 执行插入操作，返回插入后记录的id
	 * @param sql
	 * @param args
	 * @return
	 */
	long insert(String sql, Object ... args); 
	
	/**
	 * 执行 update, insert(没有返回值), delete 操作 
	 * @param sql
	 * @param args
	 */
	void update(String sql, Object ... args);
	
	/**
	 * 执行查询操作(只返回一条数据)。返回与记录对应的一个对象
	 * @param sql
	 * @param args
	 * @return
	 */
	T query(String sql, Object ... args);
	
	/**
	 * 执行查询操作(返回多条数据)，返回与记录对应的对象的集合
	 * @param sql
	 * @param args
	 * @return
	 */
	List<T> queryForList(String sql, Object...args);
	
	/**
	 * 执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 * @param sql
	 * @param args
	 * @return
	 */
	<E> E getSingleVal(String sql, Object...args);
	
	/**
	 * 执行批量更新操作
	 * @param sql
	 * @param args
	 */
	void batch(String sql, Object[]...args);
}
