package org.paypal.hackathon.project.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.paypal.hackathon.project.service.AngularService;
import org.paypal.hackathon.project.service.UserService;
import org.paypal.hackathon.project.web.view.LoginRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.paypal.hackathon.project.web.view.UserRegistrationRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

	@Autowired
	AngularService angularService;

	@Autowired
	UserService userService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/login-user/register", method=RequestMethod.POST)
	public Map<String,Object> userRegister(@RequestBody UserRegistrationRequestView userRegistrationRequestView){
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.userService.registerUser(userRegistrationRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/login-user/process", method=RequestMethod.POST)
	public Map<String,Object> loginRegister(@RequestBody LoginRequestView loginRequestView){
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.userService.loginUser(loginRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}
}
