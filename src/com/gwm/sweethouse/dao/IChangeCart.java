package com.gwm.sweethouse.dao;

public interface IChangeCart {
	public abstract void deleteCart(int user_id,int cart_id);
	public abstract void updateCartAmount(int change, int cart_id, int user_id);
}
