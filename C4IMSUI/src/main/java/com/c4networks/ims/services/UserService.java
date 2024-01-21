package com.c4networks.ims.services;

import com.c4networks.ims.model.UserDetails;

public interface UserService {

	public String registerNewUser(UserDetails userDetails, String password);

	public String processUserLogin(String userName, String password);

}
