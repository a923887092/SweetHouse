package com.gwm.sweethouse.dao.impl;

import com.gwm.sweethouse.bean.Telorder;
import com.gwm.sweethouse.dao.ZZXOrderDao;

public class ZZXOrderDaoImpl extends BaseDao<Telorder> implements ZZXOrderDao{

	@Override
	public void addUser(Telorder telorder) {
		// TODO Auto-generated method stub
		String sql = "insert into telorder (id, tel, city, name) values (?,?,?,?)";
		update(sql, telorder.getId(), telorder.getTel(), 
				telorder.getCity(), telorder.getOrder_name());
	}
}
