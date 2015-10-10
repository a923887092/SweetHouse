package com.gwm.sweethouse.web;

public class CriteriaProductDl {
	private String productdlname;
	
	private int pageNo;

	public String getProductdlname() {
		if (productdlname.equals("")) {
			productdlname = "%";
		} else {
			productdlname = "%" + productdlname + "%"; 
		}
		return productdlname;
	}

	public void setProductdlname(String productdlname) {
		this.productdlname = productdlname;
	}


	public int getPageNo() {
		return pageNo;
	}

	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	@Override
	public String toString() {
		return "CriteriaUser [username=" + productdlname + ", pageNo=" + pageNo
				+ "]";
	}

	
	public CriteriaProductDl(String productdlname, int pageNo) {
		this.productdlname = productdlname;
		this.pageNo = pageNo;
	}

	public CriteriaProductDl() {
	}
	
	
	
}
