package com.gwm.sweethouse.service;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.bean.ZxCompany;
import com.gwm.sweethouse.dao.impl.ZZXOrderDaoImpl;
import com.gwm.sweethouse.dao.impl.ZxCompanyDaoImpl;

public class ZxCompanyService {
	ZxCompanyDaoImpl zxCompanyDaoImpl = new ZxCompanyDaoImpl();
	public ArrayList<ZxCompany> search(ZxCompany zxCompany) {
		// TODO Auto-generated method stub	
		return (ArrayList<ZxCompany>) zxCompanyDaoImpl.search(zxCompany);
	}
	public ArrayList<ZxCompany> city(ZxCompany zxCompany) {
		// TODO Auto-generated method stub
		return (ArrayList<ZxCompany>)zxCompanyDaoImpl.city(zxCompany);
	}
	public ArrayList<ZxCompany> style(ZxCompany zxCompany) {
		// TODO Auto-generated method stub
		return (ArrayList<ZxCompany>)zxCompanyDaoImpl.style(zxCompany);
	}
	public ArrayList<ZxCompany> sortAsc() {
		// TODO Auto-generated method stub
		return (ArrayList<ZxCompany>)zxCompanyDaoImpl.sortAsc();
	}
	public ArrayList<ZxCompany> sortDesc() {
		// TODO Auto-generated method stub
		return (ArrayList<ZxCompany>)zxCompanyDaoImpl.sortDesc();
	}
	

}
