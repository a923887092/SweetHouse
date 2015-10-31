package com.gwm.sweethouse.service;

import com.gwm.sweethouse.bean.Wallet;
import com.gwm.sweethouse.dao.impl.MyWalletDaoImpl;

public class MyWalletService {
	MyWalletDaoImpl myWalletDaoImpl = new MyWalletDaoImpl();
	public Wallet getBalanceByUserId(int userId) {
		return myWalletDaoImpl.getBalanceByUserId(userId);
	}

}
