package com.gwm.sweethouse.dao.impl;
import java.util.ArrayList;

import com.gwm.sweethouse.bean.ZxCompany;
import com.gwm.sweethouse.dao.ZxCompanyDao;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ZxCompanyDaoImpl extends BaseDao<ZxCompany> implements ZxCompanyDao{

	@Override
	public ArrayList<ZxCompany> search(ZxCompany zxCompany) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM zxcompany WHERE zx_comName LIKE ?";
		return (ArrayList<ZxCompany>) queryForList(sql, zxCompany.getZx_comName() == "" ? "%" :"%"+zxCompany.getZx_comName()+"%");
	}

	public ArrayList<ZxCompany> city(ZxCompany zxCompany) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM zxcompany WHERE zx_comaddr LIKE ?";
		return (ArrayList<ZxCompany>) queryForList(sql, zxCompany.getZx_comaddr() == "" ? "%" : "%" + zxCompany.getZx_comaddr()+"%");
	}

	public ArrayList<ZxCompany> style(ZxCompany zxCompany) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM zxcompany WHERE zx_comstyle LIKE ?";
		return (ArrayList<ZxCompany>) queryForList(sql,  zxCompany.getZx_comaddr() == "" ? "%" : "%" + zxCompany.getZx_comaddr()+"%") ;
	}

	public ArrayList<ZxCompany> sortAsc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM zxcompany ORDER BY zx_comaprice ASC";
		return (ArrayList<ZxCompany>) queryForList(sql);
	}

	public ArrayList<ZxCompany> sortDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM zxcompany ORDER BY zx_comaprice DESC";
		return (ArrayList<ZxCompany>) queryForList(sql);
	}

	
}
