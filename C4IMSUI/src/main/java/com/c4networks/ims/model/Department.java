package com.c4networks.ims.model;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer deptId;
	private String deptName;
	private String deptDetails;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDetails() {
		return deptDetails;
	}

	public void setDeptDetails(String deptDetails) {
		this.deptDetails = deptDetails;
	}

}
