package com.gwm.sweethouse.dao;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.ProductImg;

public interface ProductImgDao<ProductImg> {
	ArrayList<ProductImg> getProductImg(int id);
}
