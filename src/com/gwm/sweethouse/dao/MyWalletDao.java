package com.gwm.sweethouse.dao;

import com.gwm.sweethouse.bean.Wallet;

public interface MyWalletDao {
	public Wallet getBalanceByUserId(int userId);
}
