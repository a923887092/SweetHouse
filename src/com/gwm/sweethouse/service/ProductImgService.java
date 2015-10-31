package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.ProductImg;
import com.gwm.sweethouse.bean.User;
import com.gwm.sweethouse.dao.impl.ProductImgImplDao;
import com.gwm.sweethouse.dao.impl.UserDaoImpl;
import com.gwm.sweethouse.web.CriteriaUser;
import com.gwm.sweethouse.web.Page;

public class ProductImgService {
	private ProductImgImplDao productImgImplDao = new ProductImgImplDao();
	public ArrayList<ProductImg> getProductImg(int id){
		return productImgImplDao.getProductImg(id);
	}
	
}
