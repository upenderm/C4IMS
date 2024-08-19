package com.c4networks.imsws.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.c4networks.imsws.vo.ProductDetails;

public class ProductDetailsMapper implements RowMapper<ProductDetails> {

	@Override
	public ProductDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDetails productDtls = new ProductDetails();

		productDtls.setProductID(rs.getString("PRODUCT_ID"));
		productDtls.setProductName(rs.getString("PRODUCT_NAME"));
		productDtls.setProductDescription(rs.getString("PRODUCT_DESC"));
		productDtls.setProductPath(rs.getString("PRODUCT_PATH"));

		return productDtls;
	}

}
