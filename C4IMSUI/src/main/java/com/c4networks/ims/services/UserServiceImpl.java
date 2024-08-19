package com.c4networks.ims.services;

import java.util.HashMap;
import java.util.Map;

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
	public String registerNewUser(UserDetails userDetails, String password, String productType,
			C4UserObject c4UserObject) {
		String result = "";
		Map<String, String> productMap = new HashMap<>();
		productMap.put(productType, null);
		if (null == userDetails.getUserName()) {
			userDetails.setUserName(userDetails.getEmail());
		}
		c4UserObject.setUserDetails(userDetails);
		UserSecurity userSecurity = new UserSecurity();
		userSecurity.setUserName(userDetails.getEmail());
		userSecurity.setPassword(password);
		c4UserObject.setUserSecurity(userSecurity);
		c4UserObject.setProductTypes(productMap);
		boolean flag = vrmsServicesClientFacade.processUserRegisteration(c4UserObject);
		if (flag) {
			result = "SUCCESS";
		}
		return result;
	}

	@Override
	public String processUserLogin(UserSecurity userSecurity) {
		String result = "";
		C4UserObject c4UserObject = vrmsServicesClientFacade.processUserLogin(userSecurity.getUserName(), userSecurity.getPassword());
		if (null != c4UserObject.getUserSecurity() && "ACTIVE".equals(c4UserObject.getUserSecurity().getStatus())) {
			if(null!=c4UserObject.getProductTypes()) {
				userSecurity.setPath(c4UserObject.getProductTypes().entrySet().iterator().next().getValue());
			}
			result = "SUCCESS";
		}
		return result;
	}

}
