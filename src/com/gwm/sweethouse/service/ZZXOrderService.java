package com.gwm.sweethouse.service;

import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.dao.impl.ZZXOrderDaoImpl;

public class ZZXOrderService {
	ZZXOrderDaoImpl zZXOrderDaoImpl = new ZZXOrderDaoImpl();
	
	public void addUser(Telorder telorder) {
		// TODO Auto-generated method stub
		zZXOrderDaoImpl.addUser(telorder);
	}

}
