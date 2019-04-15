package com.synjones.cloudcard.permission.provider.models;

import java.io.Serializable;

public class MngPageInfoRo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6737684961607679168L;
	
	private Integer		pageNo;
	
	private	Integer		pageSize;
	
	private	String		sortOrder;
	
	private	String		sortName;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	
}
