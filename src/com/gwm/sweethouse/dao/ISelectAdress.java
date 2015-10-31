package com.gwm.sweethouse.dao;

import java.util.List;

import com.gwm.sweethouse.bean.AdressBean;



public interface ISelectAdress {
	 public abstract AdressBean selectAdress(int user_id); 
	 public abstract List<AdressBean> selectAdressList();

}
