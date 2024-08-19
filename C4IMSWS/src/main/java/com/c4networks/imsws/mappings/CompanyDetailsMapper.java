package com.c4networks.imsws.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.c4networks.imsws.vo.CompanyDetails;
import com.c4networks.imsws.vo.ProductDetails;

public class CompanyDetailsMapper implements RowMapper<CompanyDetails> {

	@Override
	public CompanyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompanyDetails companyDtls = new CompanyDetails();
		ProductDetails productDtls = new ProductDetails();
		
		companyDtls.setCompanyID(rs.getString("COMPANY_ID"));
		companyDtls.setCompanyName(rs.getString("COMPANY_NAME"));
		companyDtls.setCompanyOID(rs.getString("COMPANY_OID"));
		companyDtls.setCreatedBy(rs.getString("CREATED_BY"));
		companyDtls.setCreatedDate(rs.getDate("CREATED_DATE"));
		companyDtls.setLastModifiedBy(rs.getString("LAST_MODIFIED_BY"));
		companyDtls.setLastModifiedDate(rs.getDate("LAST_MODIFIED_DATE"));
		companyDtls.setPhone(rs.getString("PHONE"));
		productDtls.setProductID(rs.getString("PRODUCT_ID"));
		companyDtls.setProductDetails(productDtls);

		return companyDtls;
	}

}
