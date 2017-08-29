package com.c4networks.ims.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.c4networks.ims.constants.WebRequestMappingConstants;
import com.c4networks.ims.model.UserDetailsBean;
import com.c4networks.ims.services.UserService;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = { WebRequestMappingConstants.WELCOME,
			WebRequestMappingConstants.BLANK })
	public String showWelcomePage() {
		logger.info("LoginController.showWelcomePage");

		return "Login2";
	}

	@RequestMapping(method = RequestMethod.POST, value = WebRequestMappingConstants.LOGIN)
	public String processLogin(HttpServletRequest request, HttpServletResponse response,
			UserDetailsBean userDetailsBean) {
		logger.info("LoginController.processLogin");
		logger.info("Username given is :" + userDetailsBean.getEmail());
		logger.info("Username given## is :" + request.getParameter("email"));
		logger.info("Password is :" + userDetailsBean.getPassword());
		try {
			Thread.sleep(2000);
			String result = userService.processUserLogin(userDetailsBean.getEmail(), userDetailsBean.getPassword());
			if(result=="SUCCESS"){
				response.setHeader("c4Token", "C4NetworkToken");
				return "redirect:http://localhost:8080/VideoRentalManagementUI/";
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Login2";
	}

	@RequestMapping(method = RequestMethod.GET, value = WebRequestMappingConstants.REGISTRATION)
	public String processRegistration() {
		logger.info("LoginController.processRegistration");

		return "";
	}

	@RequestMapping(method = RequestMethod.GET, value = WebRequestMappingConstants.LOGOUT)
	public String logout() {
		logger.info("LoginController.logout");

		return "";
	}

}
