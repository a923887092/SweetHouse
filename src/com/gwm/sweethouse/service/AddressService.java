package com.gwm.sweethouse.service;

import java.util.List;

import com.gwm.sweethouse.bean.Address;
import com.gwm.sweethouse.dao.impl.AddressDaoImpl;

public class AddressService {
	AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
	public List<Address> getAllAddress(int user_Id) {
		// TODO Auto-generated method stub
		return addressDaoImpl.getAllAddress(user_Id);

	}
	public void editAddress(Address address) {
		// TODO Auto-generated method stub
		 addressDaoImpl.editAddress(address);
	}
	public void deleteAddress(int userId, int addId) {
		// TODO Auto-generated method stub
		addressDaoImpl.deleteAddress(userId,addId);
	}
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		addressDaoImpl.addAddress(address);
	}
	
	public Address getAddressByOrder_id(int add_id) {
		// TODO Auto-generated method stub
		return addressDaoImpl.getAddressByOrder_id(add_id);
	}
}
