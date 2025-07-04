package com.c4networks.imsws.vo;

import java.io.Serializable;

public class IMSCommonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	private String clientTarget;
	private IMSErrorMessage imsErrorMsg;

	public IMSCommonVO() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientTarget() {
		return clientTarget;
	}

	public void setClientTarget(String clientTarget) {
		this.clientTarget = clientTarget;
	}

	public IMSErrorMessage getImsErrorMsg() {
		return imsErrorMsg;
	}

	public void setImsErrorMsg(IMSErrorMessage imsErrorMsg) {
		this.imsErrorMsg = imsErrorMsg;
	}

}
