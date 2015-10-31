package com.gwm.sweethouse.service;

import java.util.ArrayList;

import com.gwm.sweethouse.bean.Saled;
import com.gwm.sweethouse.dao.impl.SaledDaoImpl;

public class SaledService {
	private SaledDaoImpl saledDaoImpl = new SaledDaoImpl();
	public ArrayList<Saled> getSaledForList(){
		return saledDaoImpl.getSaledList();
	}
}
