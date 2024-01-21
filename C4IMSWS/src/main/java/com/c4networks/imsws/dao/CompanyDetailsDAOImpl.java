package com.c4networks.imsws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.vo.CompanyDetails;

@Repository
public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CREATE_SQL = "INSERT INTO C4_COMPANY_DETAILS (\r\n"
			+ "COMPANY_OID, COMPANY_ID, COMPANY_NAME, PHONE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE\r\n"
			+ ") VALUES (\r\n" + "?, ?, ?, ?, ?, ?, ?, ?\r\n" + ")";

	@Override
	public boolean createCompanyDetails(CompanyDetails companyDtls) {
		int result = jdbcTemplate.update(CREATE_SQL, companyDtls.getCompanyOID(), companyDtls.getCompanyID(),
				companyDtls.getCompanyName(), companyDtls.getPhone(), companyDtls.getCreatedBy(),
				companyDtls.getCreatedDate(), companyDtls.getLastModifiedBy(), companyDtls.getLastModifiedDate());
		return result > 0;
	}

}
