package com.gwm.sweethouse.dao.impl;

import com.gwm.sweethouse.bean.Wallet;
import com.gwm.sweethouse.dao.MyWalletDao;

public class MyWalletDaoImpl extends BaseDao<Wallet> implements MyWalletDao{

	public Wallet getBalanceByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM my_wallet WHERE user_id = ?";
		Wallet wallet = new Wallet();
		wallet = query(sql, userId);
		System.out.println(wallet.getWallet_balance()+"");
		System.out.println(wallet.toString());
		return wallet;
	}

}
