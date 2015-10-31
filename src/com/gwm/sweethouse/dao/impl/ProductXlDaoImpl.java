package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.ProductDl;
import com.gwm.sweethouse.bean.ProductXl;
import com.gwm.sweethouse.dao.ProductXlDao;
import com.gwm.sweethouse.web.CriteriaProductXl;
import com.gwm.sweethouse.web.Page;

public class ProductXlDaoImpl extends BaseDao<ProductXl> implements ProductXlDao<ProductXl> {

	public ProductXl getProduct(int id) {
		String sql = "select * from product_xl where xl_id = ?";
		return query(sql, id);
	}

	public Page<ProductXl> getPage(CriteriaProductXl cp) {
		Page<ProductXl> page = new Page<ProductXl>(cp.getPageNo());
		page.setTotalItemNum(getTotalProductNum(cp));
		//校验pageNo是否合法
		cp.setPageNo(page.getPageNo());
		page.setList(getPageList(cp, 6));
		return page;
	}

	public long getTotalProductNum(CriteriaProductXl cp) {
		String sql = "select count(xl_id) from product_xl where xl_name like ?";
		return getSingleVal(sql, cp.getCatename());
	}

	public List<ProductXl> getPageList(CriteriaProductXl cp, int pageSize) {
		String sql = "select * from product_xl where xl_name like ? limit ?, ?";
		return queryForList(sql, cp.getCatename(), (cp.getPageNo() - 1) * pageSize, pageSize);
	}

	public void addProductXl(String pd, int dl_id, String xl_pic) {
		String sql = "insert into product_xl (xl_name, dl_id, xl_pic) values (?, ?, ?)";
		update(sql, pd, dl_id, xl_pic);
	}

	public void deleteProductXl(int id) {
		String sql = "delete from product_xl where xl_id = ?";
		update(sql, id);
	}

	@Override
	public void update(ProductXl px) {
		String sql = "update product_xl set xl_name = ? where xl_id = ?";
		update(sql, px.getXl_name(), px.getXl_id());
	}

	@Override
	public List<ProductXl> getAllXl() {
		String sql = "select * from product_xl";
		return queryForList(sql);
	}

	@Override
	public List<ProductXl> getXlByDl(int dl_id) {
		String sql = "select * from product_xl where dl_id = ?";
		return queryForList(sql, dl_id);
	}

	public ArrayList<ProductXl> getXlList(ProductDl pd) {
		String sql = "select * from product_xl where dl_id = ?";
		return (ArrayList<ProductXl>) queryForList(sql, pd.getDl_id());
	}
}
