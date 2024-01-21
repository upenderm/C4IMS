package com.c4networks.imsws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.mappings.UserSecurityMapper;
import com.c4networks.imsws.vo.UserSecurity;

@Repository
public class UserSecurityDAOImpl implements UserSecurityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CREATE_SQL = "INSERT INTO C4_USER_SECURITY ("
			+ "USER_OID, USERNAME, PASSWORD, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, VERSION"
			+ ") VALUES ("
			+ "?, ?, ?, ?, ?, ?, ?, ?, ?"
			+ ")";

	private final String SQL_GET_USER_BY_USERNAME = "select * from c4_user_security where username=? and password=?";

	private final String SQL_GET_USER_BY_EMAIL = "select * from c4_user_security where username=?";

	@Override
	public UserSecurity authenticateUserSecurity(String username, String password) {

		Object[] params = { username, password };

		try {
			return jdbcTemplate.queryForObject(SQL_GET_USER_BY_USERNAME, params, new UserSecurityMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean createUserSecurity(UserSecurity userSecurity) {
		int result = jdbcTemplate.update(CREATE_SQL, userSecurity.getUserOID(), userSecurity.getUserName(),
				userSecurity.getPassword(), userSecurity.getStatus(), userSecurity.getCreatedBy(),
				userSecurity.getCreatedDate(), userSecurity.getLastModifiedBy(), userSecurity.getLastModifiedDate(),
				userSecurity.getVersion());
		return result > 0;
	}

	@Override
	public UserSecurity findUserByUsername(String email) {
		Object[] params = { email };

		try {
			return jdbcTemplate.queryForObject(SQL_GET_USER_BY_EMAIL, params, new UserSecurityMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
