package com.c4networks.ims.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.ims.client.VRMSServicesClientFacade;
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
	public IMSCommonVO processUserLogin(UserSecurity userSecurity, HttpServletResponse response) {
		IMSCommonVO imsCommonVO = new IMSCommonVO();
		imsCommonVO.setEmail(userSecurity.getUserName());
		imsCommonVO.setPassword(userSecurity.getPassword());
		return vrmsServicesClientFacade.processUserLogin(imsCommonVO, response);
	}

}
