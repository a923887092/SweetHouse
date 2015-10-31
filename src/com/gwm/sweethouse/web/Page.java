package com.gwm.sweethouse.web;

import java.util.List;

public class Page<T> {
	
	private int pageNo;
	
	private List<T> list;
	//
	private int pageSize = 6;
	
	private long totalItemNum;

	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
	public int getPageNo() {
		if (pageNo < 0) {
			pageNo = 1;
		}
		
//		if (pageNo > getTotalPageNum()) {
//			pageNo = getTotalPageNum();
//		}
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getTotalPageNum() {
		int totalPageNum = (int) (totalItemNum / pageSize);
		if(totalItemNum % pageSize > 0){
			totalPageNum++;
		}
		return totalPageNum;
	}
	public void setTotalItemNum(long totalItemNum) {
		this.totalItemNum = totalItemNum;
	}
	
	public boolean getHasNext(){
		if (pageNo < getTotalPageNum()) {
			return true;
		}
		
		return false;
	}
	
	public boolean getHasPrev(){
		if (pageNo > 1) {
			return true;
		}
		
		return false;
	}
	
	public int getPrevPage(){
		if (getHasPrev()) {
			return pageNo-1;
		}
		
		return getPageNo();
	}
	
	public int getNextPage(){
		if (getHasNext()) {
			return pageNo+1;
		}
		
		return getPageNo();
	}
}
