package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.CompanyDetail;
import com.gwm.sweethouse.dao.CompanyDetailDao;
public class CompanyDetailDaoImpl extends
			BaseDao<CompanyDetail> implements CompanyDetailDao{

	@Override
	public ArrayList<CompanyDetail> detail(CompanyDetail companyDetail) {
		String sql="SELECT * FROM comdetail WHERE dt_id=?";
		return (ArrayList<CompanyDetail>) queryForList(sql,companyDetail.getDt_id());
	}
}
