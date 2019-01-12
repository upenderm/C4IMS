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

		return "Login";
	}

	@RequestMapping(method = RequestMethod.POST, value = WebRequestMappingConstants.LOGIN)
	public String processLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			UserDetailsBean userDetailsBean, RedirectAttributes attributes) {
		logger.info("LoginController.processLogin");
		logger.info("Username given is :" + userDetailsBean.getEmail());
		logger.info("Password is :" + userDetailsBean.getPassword());
		try {
			Thread.sleep(2000);
			String result = userService.processUserLogin(userDetailsBean.getEmail(), userDetailsBean.getPassword());
			if (result == "SUCCESS") {
				Cookie cookie = new Cookie("C4TOKEN", "C4NetworkToken");
				cookie.setMaxAge(-1);
				cookie.setPath("/");
				response.addCookie(cookie);

				Cookie ssocookie = new Cookie("SSOSESSIONID", userDetailsBean.getEmail());
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

	@RequestMapping(method = RequestMethod.GET, value = WebRequestMappingConstants.REGISTRATION)
	public String processRegistration(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			UserDetailsBean userDetailsBean) {
		logger.info("LoginController.processRegistration");
		System.out.println(">>------>" + request.getHeader("c4Token"));

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if (cookie.getName().equalsIgnoreCase("c4Token")
						&& cookie.getValue().equalsIgnoreCase("C4NetworkToken")) {
				}
			}
		}

		return "views/Login2";
	}

	@RequestMapping(method = RequestMethod.GET, value = WebRequestMappingConstants.LOGOUT)
	public String logout() {
		logger.info("LoginController.logout");

		return "";
	}

}
