package com.gwm.sweethouse.bean;

public class Recommend {
	private int rec_id;
	private int product_id;
	public Recommend(int rec_id, int product_id) {
		this.rec_id = rec_id;
		this.product_id = product_id;
	}
	public Recommend() {
	}
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Recommend [rec_id=" + rec_id + ", product_id=" + product_id
				+ "]";
	}
	
}
