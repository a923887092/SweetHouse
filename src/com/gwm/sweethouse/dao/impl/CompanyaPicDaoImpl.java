package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import com.gwm.sweethouse.bean.CompanyaPic;
import com.gwm.sweethouse.dao.CompanyaPicDao;

public class CompanyaPicDaoImpl extends
		BaseDao<CompanyaPic> implements CompanyaPicDao{
	@Override
	public ArrayList<CompanyaPic> picture(CompanyaPic companyaPic) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM companyapic WHERE companyapic.com_id=?";
		return (ArrayList<CompanyaPic>) queryForList(sql,companyaPic.getCom_id());
	}
}
