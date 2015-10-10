package com.gwm.sweethouse.web;

public class CriteriaProduct {
   
	private String productname;
	private int pageNo;  
	
	public String getProductname() {
		if (productname.equals("")) {
			productname = "%";
		} else {
			productname = "%" + productname + "%"; 
		}
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "CriteriaProduct [pageNo=" + pageNo + ", productname="
				+ productname + "]";
	}

	public CriteriaProduct(String productname, int pageNo) {
		super();
		this.productname = productname;
		this.pageNo = pageNo;
	}
	public CriteriaProduct(){
		
	}
	
}
