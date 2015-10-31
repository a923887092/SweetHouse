package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.CompanyDetail;
import com.gwm.sweethouse.bean.CompanyaPic;
import com.gwm.sweethouse.dao.impl.CompanyDetailDaoImpl;
import com.gwm.sweethouse.dao.impl.CompanyaPicDaoImpl;

public class CompanyaPicService {
	CompanyaPicDaoImpl companyaPicDaoImpl = new CompanyaPicDaoImpl();

	public ArrayList<CompanyaPic> picture(CompanyaPic companyaPic) {
		// TODO Auto-generated method stub
		return companyaPicDaoImpl.picture(companyaPic);
	}
}