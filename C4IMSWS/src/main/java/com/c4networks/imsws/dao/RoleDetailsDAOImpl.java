package com.c4networks.imsws.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.imsws.vo.RoleDetails;

@Repository
public class RoleDetailsDAOImpl implements RoleDetailsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CREATE_SQL = "INSERT INTO C4_ROLE_DETAILS (\r\n" + "ROLE_ID, ROLE_NAME, COMPANY_OID\r\n"
			+ ") VALUES (\r\n" + "?, ?, ?\r\n" + ")";

	@Override
	public boolean createRoleDetails(RoleDetails roleDetails) {
		int result = jdbcTemplate.update(CREATE_SQL, roleDetails.getRoleID(), roleDetails.getRoleName(),
				roleDetails.getCompanyDetails().getCompanyID());
		return result > 0;

	}

	@Override
	public boolean createRoleDetails(List<RoleDetails> roleDetails) {

		List<Object[]> roleDtlsList = new ArrayList<>();
		for (RoleDetails rd : roleDetails) {
			System.out.println("------------------"+rd.getCompanyDetails().getCompanyOID());
			Object[] objArr = { rd.getRoleID(), rd.getRoleName(), rd.getCompanyDetails().getCompanyOID() };
			roleDtlsList.add(objArr);
		}

		int[] result = jdbcTemplate.batchUpdate(CREATE_SQL, roleDtlsList);
		return !ArrayUtils.contains(result, 0);

	}

}
