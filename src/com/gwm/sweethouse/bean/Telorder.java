package com.gwm.sweethouse.bean;

public class Telorder {
	int id;
	String tel;
	String city;
	String order_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	@Override
	public String toString() {
		return "Telorder [id=" + id + ", tel=" + tel + ", city=" + city
				+ ", order_name=" + order_name + "]";
	}
	public Telorder(int id, String tel, String city, String order_name) {
		super();
		this.id = id;
		this.tel = tel;
		this.city = city;
		this.order_name = order_name;
	}
	public Telorder() {
		super();
		// TODO Auto-generated constructor stub
	}

}
