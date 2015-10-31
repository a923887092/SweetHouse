package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.CompanyDetail;
import com.gwm.sweethouse.bean.ZxCompany;
import com.gwm.sweethouse.dao.impl.CompanyDetailDaoImpl;

public class CompanyDetailService {
	CompanyDetailDaoImpl companyDetailDaoImpl = new CompanyDetailDaoImpl();

	public ArrayList<CompanyDetail> detail(CompanyDetail companyDetail) {
		// TODO Auto-generated method stub
		return (ArrayList<CompanyDetail>)companyDetailDaoImpl.detail(companyDetail);
	}

}
