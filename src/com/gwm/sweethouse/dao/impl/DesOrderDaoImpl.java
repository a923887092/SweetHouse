package com.gwm.sweethouse.dao.impl;

import com.gwm.sweethouse.bean.DesOrder;
import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.dao.DesOrderDao;
import com.sun.faces.lifecycle.UpdateModelValuesPhase;

public class DesOrderDaoImpl extends BaseDao<Telorder> implements DesOrderDao {

	@Override
	public void addOrder(DesOrder desOrder) {
		// TODO Auto-generated method stub
		String sql = "insert into desorder1 (ord_tel, ord_addr, ord_userName,com_id,com_orderTime) values (?,?,?,?,?)";
		update(sql, desOrder.getOrd_tel(),desOrder.getOrd_addr(),desOrder.getOrd_userName(), desOrder.getCom_id(), 
				 desOrder.getOrd_orderTime());
	}
}
