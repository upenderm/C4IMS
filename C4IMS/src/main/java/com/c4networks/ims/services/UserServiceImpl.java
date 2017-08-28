package com.c4networks.ims.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.ims.dao.UserDetailsDao;
import com.c4networks.ims.model.UserDetailsBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public String registerNewUser(UserDetailsBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processUserLogin(String userName, String password) {
		Integer result = userDetailsDao.processUserLogin(userName, password);
		if (result == 1)
			return "SUCCESS";
		else if (result == 2)
			return "INVALIDCREDENTIALS";
		else
			return "FAILURE";
	}

}
