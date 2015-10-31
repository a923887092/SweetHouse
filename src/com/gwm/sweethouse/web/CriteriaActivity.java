package com.gwm.sweethouse.web;

public class CriteriaActivity {
   
	private String activityName;
	private int pageNo;  
	
	public String getActivityName() {
		if (activityName.equals("")) {
			activityName = "%";
		} else {
			activityName = "%" + activityName + "%"; 
		}
		return activityName;
	}
	
	public void setProductname(String activityName) {
		this.activityName = activityName;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "CriteriaActivity [pageNo=" + pageNo + ", activityName="
				+ activityName + "]";
	}

	public CriteriaActivity(String activityName, int pageNo) {
		super();
		this.activityName = activityName;
		this.pageNo = pageNo;
	}
	public CriteriaActivity(){
		
	}
	
}
