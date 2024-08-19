package com.c4networks.imsws.vo;

import java.io.Serializable;
import java.util.Map;

public class C4UserObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetails userDetails;
	private UserSecurity userSecurity;
	private Map<String, String> productTypes;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserSecurity getUserSecurity() {
		return userSecurity;
	}

	public void setUserSecurity(UserSecurity userSecurity) {
		this.userSecurity = userSecurity;
	}

	public Map<String, String> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(Map<String, String> productTypes) {
		this.productTypes = productTypes;
	}

}
