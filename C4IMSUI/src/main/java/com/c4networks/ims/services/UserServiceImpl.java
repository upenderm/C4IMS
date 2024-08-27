package com.c4networks.ims.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.ims.client.VRMSServicesClientFacade;
import com.c4networks.ims.model.C4UserObject;
import com.c4networks.ims.model.IMSCommonVO;
import com.c4networks.ims.model.UserSecurity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private VRMSServicesClientFacade vrmsServicesClientFacade;

	@Override
	public IMSCommonVO registerNewUser(IMSCommonVO imsCommonVO, HttpServletResponse response) {

		return vrmsServicesClientFacade.processUserRegisteration(imsCommonVO, response);
	}

	@Override
	public String processUserLogin(UserSecurity userSecurity) {
		String result = "";
		C4UserObject c4UserObject = vrmsServicesClientFacade.processUserLogin(userSecurity.getUserName(), userSecurity.getPassword());
		if (null != c4UserObject.getUserSecurity() && "ACTIVE".equals(c4UserObject.getUserSecurity().getStatus())) {
			if (null != c4UserObject.getProductTypes()) {
				userSecurity.setPath(c4UserObject.getProductTypes().entrySet().iterator().next().getValue());
			}
			result = "SUCCESS";
		}
		return result;
	}

}
