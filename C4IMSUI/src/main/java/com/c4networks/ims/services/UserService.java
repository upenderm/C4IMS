package com.c4networks.ims.services;

import javax.servlet.http.HttpServletResponse;

import com.c4networks.ims.model.IMSCommonVO;
import com.c4networks.ims.model.UserSecurity;

public interface UserService {

	public IMSCommonVO registerNewUser(IMSCommonVO imsCommonVO, HttpServletResponse response);

	public String processUserLogin(UserSecurity userSecurity);

}
