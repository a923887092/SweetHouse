package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.ProductImg;
import com.gwm.sweethouse.dao.ProductImgDao;

public class ProductImgImplDao extends BaseDao<ProductImg> implements ProductImgDao<ProductImg>{

	@Override
	public ArrayList<ProductImg> getProductImg(int id) {
		String sql = "select * from product_img where product_id = ?";
		return (ArrayList<ProductImg>) queryForList(sql, id);
	}

}
