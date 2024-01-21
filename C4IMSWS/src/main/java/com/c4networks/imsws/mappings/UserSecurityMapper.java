package com.c4networks.imsws.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.c4networks.imsws.vo.UserSecurity;

public class UserSecurityMapper implements RowMapper<UserSecurity> {

	@Override
	public UserSecurity mapRow(ResultSet rs, int rowNum) throws SQLException {
		if (rs.getRow() != 0) {
			UserSecurity us = new UserSecurity();
			us.setUserOID(rs.getString("USER_OID"));
			us.setUserName(rs.getString(("username")));
			us.setPassword(rs.getString("password"));
			us.setStatus(rs.getString("status"));
			us.setCreatedBy(rs.getString("CREATED_BY"));
			us.setCreatedDate(rs.getDate("CREATED_DATE"));
			us.setLastModifiedBy(rs.getString("LAST_MODIFIED_BY"));
			us.setLastModifiedDate(rs.getDate("LAST_MODIFIED_DATE"));
			us.setVersion(rs.getInt("version"));
			us.setTempUsername(rs.getString("temp_username"));
			return us;
		} else
			return null;
	}

}
