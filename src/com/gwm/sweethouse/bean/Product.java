package com.gwm.sweethouse.bean;

public class Product {
	private int product_id;
	private String product_name;
	private int xl_id;
	private float product_price;
	private int comment_counts;
	private float product_discount;
	private String product_photo;
	private int product_sum;
	private String product_desc;
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int productId) {
		product_id = productId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String productName) {
		product_name = productName;
	}

	public int getXl_id() {
		return xl_id;
	}

	public void setXl_id(int xlId) {
		xl_id = xlId;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float productPrice) {
		product_price = productPrice;
	}

	public int getComment_counts() {
		return comment_counts;
	}

	public void setComment_counts(int commentCounts) {
		comment_counts = commentCounts;
	}

	public float getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(float productDiscount) {
		product_discount = productDiscount;
	}

	public String getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(String productPhoto) {
		product_photo = productPhoto;
	}

	public int getProduct_sum() {
		return product_sum;
	}

	public void setProduct_sum(int productSum) {
		product_sum = productSum;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String productDesc) {
		product_desc = productDesc;
	}

	@Override
	public String toString() {
		return "Product [comment_counts=" + comment_counts + ", product_desc="
				+ product_desc + ", product_discount=" + product_discount
				+ ", product_id=" + product_id + ", product_name="
				+ product_name + ", product_photo=" + product_photo
				+ ", product_price=" + product_price + ", product_sum="
				+ product_sum + ", xl_id=" + xl_id + "]";
	}

	public Product(int productId, String productName, int xlId,
			float productPrice, int commentCounts, float productDiscount,
			String productPhoto, int productSum, String productDesc) {
		super();
		product_id = productId;
		product_name = productName;
		xl_id = xlId;
		product_price = productPrice;
		comment_counts = commentCounts;
		product_discount = productDiscount;
		product_photo = productPhoto;
		product_sum = productSum;
		product_desc = productDesc;
	}

	public Product() {
		
	}

}
