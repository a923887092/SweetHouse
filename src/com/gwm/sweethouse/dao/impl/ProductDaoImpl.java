package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.ProductImg;
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.ProductDao;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class ProductDaoImpl extends BaseDao<Product> implements
		ProductDao<Product> {

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from product_info" + " where product_id = ?";
		return query(sql, id);
	}

	public Page<Product> getPage(CriteriaProduct cp) {
		Page<Product> page = new Page<Product>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNum(cp));
		// 校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		System.out.println("22222" + getPageList(cp, 6));
		page.setList(getPageList(cp, 6));
		return page;
	}

	public List<Product> getPageList(CriteriaProduct cp, int pageSize) {
		String sql = "select * from product_info where product_name like ? limit ?, ?";
		return queryForList(sql, cp.getProductname(), (cp.getPageNo() - 1)
				* pageSize, pageSize);
	}

	public long getTotalProductNum(CriteriaProduct cp) {
		String sql = "select count(product_id) from product_info where product_name like ?";
		return getSingleVal(sql, cp.getProductname());
	}

	@Override
	public void add(Product product) {
		String sql = "insert into product_info (product_name, xl_id, "
				+ "product_price, comment_counts, product_discount, "
				+ "product_photo, product_sum, product_desc) values "
				+ "(?,?,?,?,?,?,?,?)";
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
		String sql = "insert into product_info (product_id, product_name, xl_id, "
				+ "product_price, comment_counts, product_discount, "
				+ "product_photo, product_sum, product_desc) values "
				+ "(?,?,?,?,?,?,?,?,?)";
		update(sql, product.getProduct_id(), product.getProduct_name(),
				product.getXl_id(), product.getProduct_price(),
				product.getComment_counts(), product.getProduct_discount(),
				product.getProduct_photo(), product.getProduct_sum(),
				product.getProduct_desc());

	}

	@Override
	public void update(Product product) {
		String sql = "update product_info set product_name = ?, xl_id = ?, "
				+ "product_price = ?, comment_counts = ?, product_discount = ?, "
				+ "product_photo = ?, product_sum = ?, product_desc = ? where "
				+ "product_id = ?";
		update(sql, product.getProduct_name(), product.getXl_id(),
				product.getProduct_price(), product.getComment_counts(),
				product.getProduct_discount(), product.getProduct_photo(),
				product.getProduct_sum(), product.getProduct_desc(),
				product.getProduct_id());

	}

	@Override
	public ArrayList<Product> getProductForList(int xl_id) {
		String sql = "select * from product_info" + " where xl_id = ?";
		return (ArrayList<Product>) queryForList(sql, xl_id);
	}

	public ArrayList<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String sql = "select * from product_info";
		return (ArrayList<Product>) queryForList(sql);
	}

	public Page<Product> getPageForXl(int id, CriteriaProduct cp) {
		Page<Product> page = new Page<Product>(cp.getPageNo());

		page.setTotalItemNum(getTotalProductNumForXl(id, cp));
		// 校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageListForXl(cp, 6, id));
		return page;
	}

	public List<Product> getPageListForXl(CriteriaProduct cp, int pageSize,
			int xl_id) {
		String sql = "select * from product_info where (xl_id = ? and product_name like ?)"
				+ " or (xl_id = ? and product_desc like ?) limit ?, ?";
		return queryForList(sql, xl_id, cp.getProductname(), xl_id,
				cp.getProductname(), (cp.getPageNo() - 1) * pageSize, pageSize);
	}

	public long getTotalProductNumForXl(int id, CriteriaProduct cp) {
		String sql = "select count(product_id) from product_info where (xl_id = ? and product_name like ?)"
				+ " or (xl_id = ? and product_desc like ?)";
		return getSingleVal(sql, id, cp.getProductname(), id,
				cp.getProductname());
	}

	public Page<Product> getPageForXl(int id, CriteriaProduct cp, int d) {
		Page<Product> page = new Page<Product>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNumForXl(id, cp));
		// 校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageListForXl(cp, 6, id, d));
		return page;
	}
	
	public List<Product> getPageListForXl(CriteriaProduct cp, int pageSize,
			int xl_id, int d) {
		String sql = null;
		if (d == 1) {
			sql = "select * from product_info where (xl_id = ? and product_name like ?)"
					+ " or (xl_id = ? and product_desc like ?) order by product_price desc limit ?, ?";
		} else if (d == 2){
			sql = "select * from product_info where (xl_id = ? and product_name like ?)"
					+ " or (xl_id = ? and product_desc like ?) order by product_price asc limit ?, ?";
		} else if (d == 49) {
			sql = "select * from product_info where (xl_id = ? and product_name like ?)"
					+ " or (xl_id = ? and product_desc like ?) order by saled_num desc limit ?, ?";
		} else if (d == 49) {
			sql = "select * from product_info where (xl_id = ? and product_name like ?)"
					+ " or (xl_id = ? and product_desc like ?) order by saled_num asc limit ?, ?";
		} 
		return queryForList(sql, xl_id, cp.getProductname(), xl_id,
				cp.getProductname(), (cp.getPageNo() - 1) * pageSize, pageSize);
	}

	public Page<Product> getPageForXl(int id, CriteriaProduct cp, int minPrice,
			int maxPrice) {
		Page<Product> page = new Page<Product>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNumForXl(id, cp, minPrice, maxPrice));
		// 校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageListForXl(cp, 6, id, minPrice, maxPrice));
		return page;
	}
	

	public long getTotalProductNumForXl(int id, CriteriaProduct cp, int minPrice,
			int maxPrice) {
		String sql = "select count(product_id) from product_info where (product_price BETWEEN ? AND ? and xl_id = ? and product_name like ?)"
				+ " or (product_price BETWEEN ? AND ? and xl_id = ? and product_desc like ?)";
		return getSingleVal(sql, minPrice, maxPrice, id, cp.getProductname(), minPrice, maxPrice, id,
				cp.getProductname());
	}

	@Override
	public List<Product> getPageListForXl(CriteriaProduct cp, int i, int id,
			int minPrice, int maxPrice) {
		String sql = "select * from product_info where (product_price BETWEEN ? AND ? and xl_id = ? and product_name like ?)"
				+ " or (product_price BETWEEN ? AND ? and xl_id = ? and product_desc like ?)";
		return queryForList(sql, minPrice, maxPrice, id, cp.getProductname(), minPrice, maxPrice, id,
				cp.getProductname());
	}
}
