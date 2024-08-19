package com.c4networks.imsws.dao;

import java.util.List;

import com.c4networks.imsws.vo.ProductDetails;

public interface ProductDetailsDAO {

	public boolean createProductDetails(ProductDetails productDetails);

	public List<ProductDetails> getProductDetails(String... productID);

}
