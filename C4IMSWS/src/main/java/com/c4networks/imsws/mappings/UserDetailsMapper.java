package com.c4networks.imsws.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.c4networks.imsws.vo.CompanyDetails;
import com.c4networks.imsws.vo.RoleDetails;
import com.c4networks.imsws.vo.UserDetails;

public class UserDetailsMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserDetails userDtls = new UserDetails();
		CompanyDetails companyDtls = new CompanyDetails();
		RoleDetails roleDtls = new RoleDetails();

		userDtls.setC4UserOID(rs.getString("C4_USER_OID"));
		userDtls.setUserName(rs.getString("USERNAME"));
		userDtls.setEmail(rs.getString("EMAIL"));
		userDtls.setFirstName(rs.getString("FIRST_NAME"));
		userDtls.setLastName(rs.getString("LAST_NAME"));
		userDtls.setMobile(rs.getString("MOBILE"));
		userDtls.setCreatedBy(rs.getString("CREATED_BY"));
		userDtls.setCreatedDate(rs.getDate("CREATED_DATE"));
		userDtls.setLastModifiedBy(rs.getString("LAST_MODIFIED_BY"));
		userDtls.setLastModifiedDate(rs.getDate("LAST_MODIFIED_DATE"));

		companyDtls.setCompanyID(rs.getString("COMPANY_OID"));
		userDtls.setCompanyDetails(companyDtls);

		roleDtls.setRoleID(rs.getString("ROLE_ID"));
		userDtls.setRoleDetails(roleDtls);

		return userDtls;
	}

}
