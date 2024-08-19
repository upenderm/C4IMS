package com.c4networks.imsws.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.mappings.ProductDetailsMapper;
import com.c4networks.imsws.vo.ProductDetails;

@Repository
public class ProductDetailsDAOImpl implements ProductDetailsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CREATE_SQL = "INSERT INTO C4_PRODUCT_DETAILS (\r\n"
			+ "PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PATH\r\n" + ") VALUES (\r\n" + "?, ?, ?, ?\r\n" + ")";

	private final String SQL_GET_PRODUCT_DETAILS = "select * from C4_PRODUCT_DETAILS where PRODUCT_ID = ?";

	@Override
	public boolean createProductDetails(ProductDetails productDetails) {
		int result = jdbcTemplate.update(CREATE_SQL, productDetails.getProductID(), productDetails.getProductName(),
				productDetails.getProductDescription(), productDetails.getProductPath());
		return result > 0;
	}

	@Override
	public List<ProductDetails> getProductDetails(String... productID) {
		return jdbcTemplate.query(SQL_GET_PRODUCT_DETAILS, productID, new ProductDetailsMapper());
	}

}
