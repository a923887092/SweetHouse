package com.gwm.sweethouse.dao.impl;

import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.ProductDao;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao<Product> {

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from product_info" +
		" where product_id = ?";
        return query(sql, id);
	}

	public Page<Product> getPage(CriteriaProduct cp) {
		Page<Product> page = new Page<Product>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNum(cp));
		//校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageList(cp, 5));
		return page;
	}
	public List<Product> getPageList(CriteriaProduct cp, int pageSize) {
		String sql = "select * from product_info where product_name like ? limit ?, ?";
		return queryForList(sql, cp.getProductname(), 
				(cp.getPageNo() - 1) * pageSize, pageSize);
	}
	public long getTotalProductNum(CriteriaProduct cp) {
		String sql = "select count(product_id) from product_info where product_name like ?";
		return getSingleVal(sql, cp.getProductname());
	}

	@Override
	public void add(Product product) {
		String sql = "insert into product_info (product_name, xl_id, " +
				"product_price, comment_counts, product_discount, " +
				"product_photo, product_sum, product_desc) values " +
				"(?,?,?,?,?,?,?,?)";
		update(sql, product.getProduct_name(), product.getXl_id(), 
				product.getProduct_price(), product.getComment_counts(),
				product.getProduct_discount(), product.getProduct_photo(),
				product.getProduct_sum(), product.getProduct_desc());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from product_info where product_id = ?";
		update(sql, id);
	}

	@Override
	public void add2(Product product) {
		String sql = "insert into product_info (product_id, product_name, xl_id, " +
				"product_price, comment_counts, product_discount, " +
				"product_photo, product_sum, product_desc) values " +
				"(?,?,?,?,?,?,?,?,?)";
		update(sql,product.getProduct_id(), product.getProduct_name(), product.getXl_id(), 
				product.getProduct_price(), product.getComment_counts(),
				product.getProduct_discount(), product.getProduct_photo(),
				product.getProduct_sum(), product.getProduct_desc());
		
	}

	@Override
	public void update(Product product) {
		String sql = "update product_info set product_name = ?, xl_id = ?, " +
				"product_price = ?, comment_counts = ?, product_discount = ?, " +
				"product_photo = ?, product_sum = ?, product_desc = ? where " +
				"product_id = ?";
		update(sql,product.getProduct_name(), product.getXl_id(), 
		product.getProduct_price(), product.getComment_counts(),
		product.getProduct_discount(), product.getProduct_photo(),
		product.getProduct_sum(), product.getProduct_desc(),product.getProduct_id());
		
	}

	

}
