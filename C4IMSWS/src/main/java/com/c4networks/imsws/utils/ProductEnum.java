package com.c4networks.imsws.utils;

public enum ProductEnum {

	VRMS("VRMS", "VRMS", "VideoRentalManagementSystem", "http://localhost:8080/VideoRentalManagementUI/"),
	CDMS("CDMS", "CDMS", "ContractDocumentsManagementSystem", "http://localhost:8080/ContractDocumentsManagementUI");

	private String productID;
	private String productName;
	private String productDesc;
	private String productPath;

	private ProductEnum(String productID, String productName, String productDesc, String productPath) {
		this.productID = productID;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPath = productPath;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public String getProductPath() {
		return productPath;
	}

	public String getProductName() {
		return productName;
	}

}
