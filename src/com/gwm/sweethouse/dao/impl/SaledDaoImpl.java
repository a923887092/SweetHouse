package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Saled;
import com.gwm.sweethouse.dao.SaledDao;
import com.gwm.sweethouse.web.CriteriaProduct;
import com.gwm.sweethouse.web.Page;

public class SaledDaoImpl extends BaseDao<Saled> implements SaledDao<Saled> {

	@Override
	public Saled getSaled(int id) {
		String sql = "select b.sale_id,b.product_id, a.product_name,a.product_photo,a.product_desc,a.product_price,a.product_discount from product_info a,product_sale b where a.product_id=b.product_id and b.sale_id = ?";
		return query(sql, id);
	}

	@Override
	public Page<Saled> getPage(CriteriaProduct cp) {
		Page<Saled> page = new Page<Saled>(cp.getPageNo());
		page.setTotalItemNum(getTotalSaledNum(cp));
		cp.setPageNo(page.getPageNo());
		page.setList(getSaledList());
		return page;
	}

	@Override
	public long getTotalSaledNum(CriteriaProduct cp) {
		String sql = "select count(sale_id) from product_sale,product_info where product_info.product_name like ?";
		return getSingleVal(sql, cp.getProductname());
	}

	@Override
	public List<Saled> getPageList(CriteriaProduct cp, int pageSize) {
		String sql = "select b.sale_id,b.product_id, a.product_name,a.product_photo,a.product_desc,a.product_price,a.product_discount from product_info a,product_sale b where a.product_id=b.product_id and a.product_name=? limit ?, ?";
		return queryForList(sql, cp.getProductname(), (cp.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public ArrayList<Saled> getSaledList() {
		String sql = "select b.sale_id,b.product_id, a.product_name,a.product_photo,a.product_desc,a.product_price,a.product_discount from product_info a,product_sale b where a.product_id=b.product_id";
		return (ArrayList<Saled>) queryForList(sql);
	}

}
