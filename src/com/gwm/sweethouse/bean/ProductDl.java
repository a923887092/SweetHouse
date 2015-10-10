package com.gwm.sweethouse.bean;

public class ProductDl {
	private int dl_id;
	private String dl_name;
	
	public int getDl_id() {
		return dl_id;
	}
	
	public void setDl_id(int dl_id) {
		this.dl_id = dl_id;
	}

	public String getDl_name() {
		return dl_name;
	}

	public void setDl_name(String dl_name) {
		this.dl_name = dl_name;
	}
	
	public ProductDl(int dl_id, String dl_name) {
		this.dl_id = dl_id;
		this.dl_name = dl_name;
	}
	
	public ProductDl() {
	}
	
	@Override
	public String toString() {
		return "ProductDl [dl_id=" + dl_id + ", dl_name=" + dl_name + "]";
	}
	
}
