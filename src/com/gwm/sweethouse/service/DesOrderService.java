package com.gwm.sweethouse.service;

import com.gwm.sweethouse.bean.DesOrder;
import com.gwm.sweethouse.dao.impl.DesOrderDaoImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class DesOrderService {
	DesOrderDaoImpl desOrderDaoImpl=new DesOrderDaoImpl();
	public void addOrder(DesOrder desorder) {
		// TODO Auto-generated method stub
		desOrderDaoImpl.addOrder(desorder);
	}

}
