package com.c4networks.imsws.dao;

import java.util.List;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.mappings.UserDetailsMapper;
import com.c4networks.imsws.vo.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	/* the JDBC template reference name need not match the bean reference name */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL_USERS = "select * from c4_user_details";

	private final String CREATE_SQL = "INSERT INTO C4_USER_DETAILS (\r\n"
			+ "C4_USER_OID, USERNAME, EMAIL, FIRST_NAME, LAST_NAME, MOBILE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, ROLE_ID, COMPANY_OID\r\n"
			+ ") VALUES (\r\n" + "?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?\r\n" + ")";
	
	private final String SQL_GET_USER_DETAILS = "select * from c4_user_details where c4_user_oid = ?";

	public UserDetailsDAOImpl() {

	}

	@Override
	public List<UserDetails> getUserDetailsById(String... userOID) {
		return jdbcTemplate.query(SQL_GET_USER_DETAILS, userOID, new UserDetailsMapper());
	}

	@Override
	public List<UserDetails> getAllUsersList() {
		return jdbcTemplate.query(SQL_GET_ALL_USERS, new UserDetailsMapper());
	}

	@Override
	public List<UserDetails> getAllUsersByCompanyID(String companyOID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createUserDetails(UserDetails userDtls) {
		int result = jdbcTemplate.update(CREATE_SQL, userDtls.getC4UserOID(), userDtls.getUserName(),
				userDtls.getEmail(), userDtls.getFirstName(), userDtls.getLastName(), userDtls.getMobile(),
				userDtls.getCreatedBy(), userDtls.getCreatedDate(), userDtls.getLastModifiedBy(),
				userDtls.getLastModifiedDate(), userDtls.getRoleDetails().getRoleID(), userDtls.getCompanyDetails().getCompanyOID());
		return result > 0;
	}

	@Override
	public boolean deleteUserDetails(UserDetails userDtls) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserDetails(UserDetails userDtls) {
		// TODO Auto-generated method stub
		return false;
	}

}
