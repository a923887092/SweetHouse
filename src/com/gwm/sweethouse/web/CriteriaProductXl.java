package com.gwm.sweethouse.web;

public class CriteriaProductXl {
	private String catename;
	
	private int pageNo;
	
	public String getCatename() {
		if (catename.equals("")) {
			catename = "%";
		} else {
			catename = "%" + catename + "%"; 
		}
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}


	public int getPageNo() {
		return pageNo;
	}

	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	@Override
	public String toString() {
		return "CriteriaUser [username=" + catename + ", pageNo=" + pageNo
				+ "]";
	}

	
	public CriteriaProductXl(String catename, int pageNo) {
		this.catename = catename;
		this.pageNo = pageNo;
	}

	public CriteriaProductXl() {
	}
}
