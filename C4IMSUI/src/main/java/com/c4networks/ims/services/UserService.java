package com.c4networks.ims.services;

import com.c4networks.ims.model.C4UserObject;
import com.c4networks.ims.model.UserDetails;
import com.c4networks.ims.model.UserSecurity;

public interface UserService {

	public String registerNewUser(UserDetails userDetails, String password, String productType, C4UserObject c4UserObject);

	public String processUserLogin(UserSecurity userSecurity);

}
