package com.gwm.sweethouse.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.impl.ProductDaoImpl;
import com.gwm.sweethouse.dao.impl.ProductDlDaoImpl;
import com.gwm.sweethouse.dao.impl.ProductXlDaoImpl;
import com.gwm.sweethouse.dao.impl.UserDaoImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductDlDaoImplTest {

	private ProductDlDaoImpl productDlDaoImpl = new ProductDlDaoImpl();
	private ProductXlDaoImpl productXlDaoImpl = new ProductXlDaoImpl();
	private ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@Test
	public void test() {
		String sql = "update product_info set product_name = ?, xl_id = ?, " +
				"product_price = ?, comment_counts = ?, product_discount = ?, " +
				"product_photo = ?, product_sum = ?, product_desc = ? where " +
				"product_id = ?";
		productDaoImpl.update(sql, "123",7,71.1,11,0.1,"121",11,"wqewqeqw", 8);
	}
	@Test
	public void testGetTotalUserNum() {
		String sql = "select * from product_info where (xl_id = ? and product_name like ?)" +
				" or (xl_id = ? and product_desc like ?) order by product_price desc limit ?, ?";
		       System.out.println(productDaoImpl.queryForList(sql, 8, "%", 8, "%", 0, 6));
	}

	@Test
	public void testGetPageList() {
		String sql = "select count(product_id) from product_info where (product_price BETWEEN ? AND ? and xl_id = ? and product_name like ?)"
				+ " or (product_price BETWEEN ? AND ? and xl_id = ? and product_desc like ?)";
		System.out.println(productXlDaoImpl.getSingleVal(sql, 200, 800, 8, "%", 200, 800, 8, "%"));
	}

	@Test
	public void testGetState() {
		String sql = "insert into product_info (product_name, xl_id, " +
				"product_price, comment_counts, product_discount, " +
				"product_photo, product_sum, product_desc) values " +
				"(?,?,?,?,?,?,?,?)";
		productDaoImpl.update(sql, "aadas", 2, 12.2, 21, 0.9, "dsfds", 123, "dsfsdf");
	}

}
