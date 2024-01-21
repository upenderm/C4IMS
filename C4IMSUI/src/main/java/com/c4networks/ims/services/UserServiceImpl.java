package com.c4networks.ims.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.ims.client.VRMSServicesClientFacade;
import com.c4networks.ims.model.C4UserObject;
import com.c4networks.ims.model.UserDetails;
import com.c4networks.ims.model.UserSecurity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private VRMSServicesClientFacade vrmsServicesClientFacade;

	@Override
	public String registerNewUser(UserDetails userDetails, String password) {
		String result = "";
		C4UserObject c4UserObject = new C4UserObject();
		if (null == userDetails.getUserName()) {
			userDetails.setUserName(userDetails.getEmail());
		}
		c4UserObject.setUserDetails(userDetails);
		UserSecurity userSecurity = new UserSecurity();
		userSecurity.setUserName(userDetails.getEmail());
		userSecurity.setPassword(password);
		c4UserObject.setUserSecurity(userSecurity);
		boolean flag = vrmsServicesClientFacade.processUserRegisteration(c4UserObject);
		if (flag) {
			result = "SUCCESS";
		}
		return result;
	}

	@Override
	public String processUserLogin(String userName, String password) {
		String result = "";
		UserSecurity usrSecurity = vrmsServicesClientFacade.processUserLogin(userName, password);
		if ("ACTIVE".equals(usrSecurity.getStatus())) {
			result = "SUCCESS";
		}
		return result;
	}

}
