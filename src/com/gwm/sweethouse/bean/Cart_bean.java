package com.gwm.sweethouse.bean;
public class Cart_bean {
	 	private int goods_amount;
	    private String goodsname;
	    private String goodsDescribe;
	    private String imagesrc;
	    private int price;
	    private int cart_id;
		public Cart_bean(int goods_amount, String goodsname,
				String goodsDescribe, String imagesrc, int price, int cart_id) {
			super();
			this.goods_amount = goods_amount;
			this.goodsname = goodsname;
			this.goodsDescribe = goodsDescribe;
			this.imagesrc = imagesrc;
			this.price = price;
			this.cart_id = cart_id;
		}
		public int getCart_id() {
			return cart_id;
		}
		public void setCart_id(int cart_id) {
			this.cart_id = cart_id;
		}
		public int getGoods_amount() {
			return goods_amount;
		}
		public void setGoods_amount(int goods_amount) {
			this.goods_amount = goods_amount;
		}
		public String getGoodsname() {
			return goodsname;
		}
		public void setGoodsname(String goodsname) {
			this.goodsname = goodsname;
		}
		public String getGoodsDescribe() {
			return goodsDescribe;
		}
		public void setGoodsDescribe(String goodsDescribe) {
			this.goodsDescribe = goodsDescribe;
		}
		public String getImagesrc() {
			return imagesrc;
		}
		public void setImagesrc(String imagesrc) {
			this.imagesrc = imagesrc;
		}
		public int getPrice() {
			return price;
		}
		public Cart_bean() {
			super();
		}
		public Cart_bean(int goods_amount, String goodsname,
				String goodsDescribe, String imagesrc, int price) {
			super();
			this.goods_amount = goods_amount;
			this.goodsname = goodsname;
			this.goodsDescribe = goodsDescribe;
			this.imagesrc = imagesrc;
			this.price = price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Cart_bean [goods_amount=" + goods_amount + ", goodsname="
					+ goodsname + ", goodsDescribe=" + goodsDescribe
					+ ", imagesrc=" + imagesrc + ", price=" + price
					+ ", cart_id=" + cart_id + "]";
		}
}
