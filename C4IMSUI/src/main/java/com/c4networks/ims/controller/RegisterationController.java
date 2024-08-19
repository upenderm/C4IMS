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

import com.c4networks.ims.constants.WebRequestMappingConstants;
import com.c4networks.ims.model.C4UserObject;
import com.c4networks.ims.model.UserDetails;
import com.c4networks.ims.services.UserService;

@Controller
public class RegisterationController {

	Logger logger = Logger.getLogger(RegisterationController.class.getName());

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = WebRequestMappingConstants.REGISTRATION)
	public String processRegistration(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			UserDetails userDetails) {
		logger.info("LoginController.processRegistration");
		System.out.println(">>------>" + request.getHeader("c4Token"));
		String password = request.getParameter("password");
		System.out.println("password------------"+password);
		String productType = request.getParameter("productType");
		System.out.println("password------------"+productType);
		try {
			Thread.sleep(1000);
			C4UserObject c4UserObject = new C4UserObject();
			String result = userService.registerNewUser(userDetails, password, productType, c4UserObject);
			if (result == "SUCCESS") {
				Cookie cookie = new Cookie("C4TOKEN", "C4NetworkToken");
				cookie.setMaxAge(-1);
				cookie.setPath("/");
				response.addCookie(cookie);

				Cookie ssocookie = new Cookie("SSOSESSIONID", userDetails.getEmail());
				ssocookie.setMaxAge(-1);
				ssocookie.setPath("/");
				response.addCookie(ssocookie);

//				return "redirect:http://localhost:8080/VideoRentalManagementUI/";
				return "redirect:"+c4UserObject.getProductTypes().get(productType);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		model.addAttribute("loginError", "Unable to Register man...");
		return "Login";
	}

}
