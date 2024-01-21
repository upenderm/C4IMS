package com.c4networks.ims.controller;

import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c4networks.ims.constants.WebRequestMappingConstants;
import com.c4networks.ims.model.UserSecurity;
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

		return "Login";
	}

	@RequestMapping(method = RequestMethod.POST, value = WebRequestMappingConstants.LOGIN)
	public String processLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			UserSecurity userSecurity, RedirectAttributes attributes) {
		logger.info("LoginController.processLogin");
		logger.info("Username given is :" + userSecurity.getUserName());
		logger.info("Password is :" + userSecurity.getPassword());
		try {
			System.out.println("model------------"+model.get("password"));
			Thread.sleep(2000);
			String result = userService.processUserLogin(userSecurity.getUserName(), userSecurity.getPassword());
			if (result == "SUCCESS") {
				Cookie cookie = new Cookie("C4TOKEN", "C4NetworkToken");
				cookie.setMaxAge(-1);
				cookie.setPath("/");
				response.addCookie(cookie);

				Cookie ssocookie = new Cookie("SSOSESSIONID", userSecurity.getUserName());
				ssocookie.setMaxAge(-1);
				ssocookie.setPath("/");
				response.addCookie(ssocookie);

				return "redirect:http://localhost:8080/VideoRentalManagementUI/";
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		model.addAttribute("loginError", "Unable to Login man...");
		return "Login";
	}

	@RequestMapping(method = RequestMethod.GET, value = WebRequestMappingConstants.LOGOUT)
	public String logout() {
		logger.info("LoginController.logout");

		return "";
	}

}
