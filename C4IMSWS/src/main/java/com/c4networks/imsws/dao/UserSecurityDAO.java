package com.c4networks.imsws.dao;

import com.c4networks.imsws.vo.UserSecurity;

public interface UserSecurityDAO {
	
	public UserSecurity authenticateUserSecurity(String username, String password);
	
	public boolean createUserSecurity(UserSecurity userSecurity);
	
	public UserSecurity findUserByUsername(String email);

}
