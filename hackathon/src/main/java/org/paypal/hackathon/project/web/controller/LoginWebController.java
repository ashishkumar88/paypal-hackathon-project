package org.paypal.hackathon.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginWebController {

	@RequestMapping(value="/login-user", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("login", null);
	}


	@RequestMapping(value="/login-signup", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		return new ModelAndView("loginsignup", null);
	}
}
