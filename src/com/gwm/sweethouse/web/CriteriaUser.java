package com.gwm.sweethouse.web;

public class CriteriaUser {
	private String username;
	
	private int pageNo;

	public String getUsername() {
		if (username.equals("")) {
			username = "%";
		} else {
			username = "%" + username + "%"; 
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public int getPageNo() {
		return pageNo;
	}

	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	@Override
	public String toString() {
		return "CriteriaUser [username=" + username + ", pageNo=" + pageNo
				+ "]";
	}

	
	public CriteriaUser(String username, int pageNo) {
		this.username = username;
		this.pageNo = pageNo;
	}

	public CriteriaUser() {
	}
	
	
	
}
