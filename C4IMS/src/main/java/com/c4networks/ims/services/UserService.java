package com.c4networks.ims.services;

import com.c4networks.ims.model.UserDetailsBean;

public interface UserService {

	public String registerNewUser(UserDetailsBean userBean);

	public String processUserLogin(String userName, String password);

}
