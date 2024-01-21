package com.c4networks.imsws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.imsws.dao.UserDetailsDAO;
import com.c4networks.imsws.dao.UserSecurityDAO;
import com.c4networks.imsws.vo.UserDetails;
import com.c4networks.imsws.vo.UserSecurity;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDAO userDtlsDAO;

	@Autowired
	private UserSecurityDAO userSecurityDAO;

	public List<UserDetails> getAllUsersList() {

		return userDtlsDAO.getAllUsersList();
	}

	public UserSecurity authenticateUserCredentials(String username, String password) {
		UserSecurity userSecurity = userSecurityDAO.authenticateUserSecurity(username, password);
		if (null != userSecurity) {
			return userSecurity;
		} else {
			return new UserSecurity();
		}
	}

	public boolean isUsernameAvailable(String email) {
		UserSecurity userSecurity = userSecurityDAO.findUserByUsername(email);
		return (null == userSecurity);
	}

}
