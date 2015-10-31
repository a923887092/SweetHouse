package com.gwm.sweethouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwm.sweethouse.bean.Address;
import com.gwm.sweethouse.dao.AddressDao;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao{
    List< Address> list = new ArrayList<Address>();
	public List<Address> getAllAddress(int user_Id) {
		// TODO Auto-generated method stub
		String sql = "select * from order_address where user_id = ?";
		list = queryForList(sql, user_Id);
		return list;
	}
	public void editAddress(Address address) {
		// TODO Auto-generated method stub
		String sql = "UPDATE order_address " +
				"SET add_name = ?,add_phone= ?,add_address = ?" +
				"WHERE user_id = ? AND add_id= ?";
		update(sql,address.getAdd_name(),address.getAdd_phone(),address.getAdd_address(),address.getUser_id(),address.getAdd_id());
	    System.out.println(address.toString());
		System.out.println("成功修改");
	}
	public void deleteAddress(int userId, int addId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM order_address WHERE user_id = ？ AND add_id=？";
		update(sql,userId,addId);
		//update(sql);
		System.out.println("成功删除");
	}
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		String sql = "insert into order_address (user_id, add_name, add_phone,add_address) values" +
		             "(?,?,?,?)";
		System.out.println(address.getAdd_name()+"::::"+address.getAdd_address());
	    update(sql,address.getUser_id(),address.getAdd_name(),address.getAdd_phone(),address.getAdd_address());
		//update(sql, address.getUser_id(), "各位美女", "123145464", "圣诞节快乐加快实施科技开发了");
	}
	public Address getAddressByOrder_id(int add_id) {
		String sql = "select * from order_address where add_id = ?";
		return query(sql,add_id);
		// TODO Auto-generated method stub
		
	}

}
