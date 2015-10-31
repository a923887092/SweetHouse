package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.bean.Address;

public interface AddressDao  {
	public List<Address> getAllAddress(int userId);
	public void editAddress(Address address);
	public void deleteAddress(int userId, int addId);
	public void addAddress(Address address);
	public Address getAddressByOrder_id(int add_id);
}
