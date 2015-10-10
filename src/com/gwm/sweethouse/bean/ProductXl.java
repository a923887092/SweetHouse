package com.gwm.sweethouse.bean;

public class ProductXl {
	private int xl_id;
	private String xl_name;
	private int dl_id;
	
	public int getXl_id() {
		return xl_id;
	}
	public void setXl_id(int xl_id) {
		this.xl_id = xl_id;
	}
	public String getXl_name() {
		return xl_name;
	}
	public void setXl_name(String xl_name) {
		this.xl_name = xl_name;
	}
	public int getDl_id() {
		return dl_id;
	}
	public void setDl_id(int dl_id) {
		this.dl_id = dl_id;
	}
	public ProductXl(int xl_id, String xl_name, int dl_id) {
		this.xl_id = xl_id;
		this.xl_name = xl_name;
		this.dl_id = dl_id;
	}
	public ProductXl() {
	}
	@Override
	public String toString() {
		return "ProductXl [xl_id=" + xl_id + ", xl_name=" + xl_name
				+ ", dl_id=" + dl_id + "]";
	}
	
	
}
