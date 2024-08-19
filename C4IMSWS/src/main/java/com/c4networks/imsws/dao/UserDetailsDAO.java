package com.c4networks.imsws.dao;

import java.util.List;

import com.c4networks.imsws.vo.UserDetails;

public interface UserDetailsDAO {

	public List<UserDetails> getUserDetailsById(String... userOID);

	public List<UserDetails> getAllUsersList();

	public List<UserDetails> getAllUsersByCompanyID(String companyOID);

	public boolean deleteUserDetails(UserDetails userDtls);

	public boolean updateUserDetails(UserDetails userDtls);

	public boolean createUserDetails(UserDetails userDtls);

}
