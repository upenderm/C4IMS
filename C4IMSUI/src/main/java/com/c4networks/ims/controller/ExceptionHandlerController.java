package com.c4networks.ims.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String DB_CONNECTION_ERROR_VIEW = "dbError";

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

		mav.addObject("datetime", new Date());
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}

}
