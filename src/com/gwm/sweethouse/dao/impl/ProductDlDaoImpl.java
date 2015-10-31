package com.gwm.sweethouse.dao.impl;

import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.dao.ProductDlDao;
import com.gwm.sweethouse.web.CriteriaProductDl;
import com.gwm.sweethouse.web.Page;

public class ProductDlDaoImpl extends BaseDao<ProductDl> implements ProductDlDao {

	public ProductDl getProduct(int id) {
		String sql = "select * from product_dl where dl_id = ?";
		return query(sql, id);
	}

	public Page<ProductDl> getPage(CriteriaProductDl cp) {
		Page<ProductDl> page = new Page<ProductDl>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNum(cp));
		//校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageList(cp, 6));
		return page;
	}

	public long getTotalProductNum(CriteriaProductDl cp) {
		String sql = "select count(dl_id) from product_dl where dl_name like ?";
		return getSingleVal(sql, cp.getProductdlname());
	}

	public List<ProductDl> getPageList(CriteriaProductDl cp, int pageSize) {
		String sql = "select * from product_dl where dl_name like ? limit ?, ?";
		return queryForList(sql, cp.getProductdlname(), (cp.getPageNo() - 1) * pageSize, pageSize);
	}

	public void addProductDl(String pd) {
		String sql = "insert into product_dl (dl_name) values (?)";
		update(sql, pd);
	}

	public void deleteProductDl(int id) {
		String sql = "delete from product_dl where dl_id = ?";
		update(sql, id);
	}
	public void updateProductDl(String name, int id) {
		String sql = "update product_dl set dl_name = ? where dl_id = ?";
		update(sql, name, id);
	}

	@Override
	public List<ProductDl> getAllDl() {
		String sql = "select * from product_dl";
		return queryForList(sql);
	}

	@Override
	public ProductDl getProduct(String name) {
		String sql = "select * from product_dl where dl_name = ?";
		return query(sql, name);
	}

}
