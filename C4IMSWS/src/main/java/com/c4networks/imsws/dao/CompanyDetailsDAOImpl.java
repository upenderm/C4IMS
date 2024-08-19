package com.c4networks.imsws.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.mappings.CompanyDetailsMapper;
import com.c4networks.imsws.vo.CompanyDetails;

@Repository
public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CREATE_SQL = "INSERT INTO C4_COMPANY_DETAILS (\r\n"
			+ "COMPANY_OID, COMPANY_ID, COMPANY_NAME, PHONE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, PRODUCT_ID\r\n"
			+ ") VALUES (\r\n" + "?, ?, ?, ?, ?, ?, ?, ?, ?\r\n" + ")";
	
	private final String SQL_GET_COMPANY_DETAILS = "select * from c4_company_details where company_oid = ?";

	@Override
	public boolean createCompanyDetails(CompanyDetails companyDtls) {
		int result = jdbcTemplate.update(CREATE_SQL, companyDtls.getCompanyOID(), companyDtls.getCompanyID(),
				companyDtls.getCompanyName(), companyDtls.getPhone(), companyDtls.getCreatedBy(),
				companyDtls.getCreatedDate(), companyDtls.getLastModifiedBy(), companyDtls.getLastModifiedDate(), companyDtls.getProductDetails().getProductID());
		return result > 0;
	}

	@Override
	public List<CompanyDetails> getCompanyDetails(String... companyOID) {
		
		return jdbcTemplate.query(SQL_GET_COMPANY_DETAILS, companyOID, new CompanyDetailsMapper());
	}

}
