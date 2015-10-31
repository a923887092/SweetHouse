package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Product;
import com.gwm.sweethouse.bean.Recommend;
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.ProductDao;
import com.gwm.sweethouse.dao.RecommendDao;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public class RecommendDaoImpl extends BaseDao<Recommend> implements RecommendDao<Recommend> {

	@Override
	public Recommend getReconmmend(int id) {
		String sql = "select * from pro_recommend" +
				" where rec_id = ?";
		        return query(sql, id);
	}

	@Override
	public Page<Recommend> getPage(CriteriaProduct cp) {
		Page<Recommend> page = new Page<Recommend>(cp.getPageNo());
		System.out.println("getPage" + cp.getPageNo());
		page.setTotalItemNum(getTotalReconmmendNum(cp));
		//校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		System.out.println("wuyu0:" + getTotalReconmmendNum(cp));
		System.out.println("wuyu1:" + page.getPageNo());
		System.out.println("wuyu:" + page.getPageNo());
		page.setList(getPageList(cp, 6));
		return page;
	}
	@Override
	public long getTotalReconmmendNum(CriteriaProduct cp) {
		String sql = "SELECT COUNT(b.`rec_id`) FROM product_info a JOIN pro_recommend b ON a.`product_id`=b.`product_id` WHERE a.`product_name` LIKE ?";
		return getSingleVal(sql, cp.getProductname());
	}

	@Override
	public List<Recommend> getPageList(CriteriaProduct cp, int pageSize) {
		String sql = "SELECT b.`rec_id`,b.`product_id`,a.`product_name`," +
				"a.`product_photo`,a.`product_desc`,a.`product_price` " +
				"FROM product_info a JOIN " +
				"pro_recommend b ON a.`product_id`=b.`product_id` " +
				"WHERE a.`product_name` LIKE ? limit ?, ?";
		System.out.println("666666666666" + (cp.getPageNo() - 1) * pageSize);
		System.out.println("666666666666" + cp.getPageNo());
		return queryForList(sql, cp.getProductname(), 
				(cp.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public ArrayList<Recommend> getRecommendList() {
		String sql = "SELECT b.`rec_id`,b.`product_id`,a.`product_name`," +
				"a.`product_photo`,a.`product_desc`,a.`product_price` " +
				"FROM product_info a JOIN	" +
				"pro_recommend b ON a.`product_id`=b.`product_id`";
		return (ArrayList<Recommend>) queryForList(sql);
	}

	public void update(int recId, int productId) {
		// TODO Auto-generated method stub
		String sql = "update pro_recommend set product_id = ? where rec_id = ?";
		update(sql, productId, recId);
	}

	/*@Override
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
		
	}*/

	

}
