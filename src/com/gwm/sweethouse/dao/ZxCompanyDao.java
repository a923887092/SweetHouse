package com.gwm.sweethouse.dao;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.bean.ZxCompany;

public interface ZxCompanyDao {
	
	public ArrayList<ZxCompany> search(ZxCompany zxCompany) ;
	public ArrayList<ZxCompany> city(ZxCompany zxCompany) ;
	public ArrayList<ZxCompany> style(ZxCompany zxCompany) ;
	public ArrayList<ZxCompany> sortAsc() ;
	public ArrayList<ZxCompany> sortDesc() ;
}
