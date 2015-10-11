package org.paypal.hackathon.project.service;

import org.paypal.hackathon.project.web.view.LoginRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.paypal.hackathon.project.web.view.UserRegistrationRequestView;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public ResponseStatusView registerUser(UserRegistrationRequestView userRegistrationRequestView) {
		System.out.println(userRegistrationRequestView);
		return null;
	}

	public ResponseStatusView loginUser(LoginRequestView loginRequestView) {
		System.out.println(loginRequestView);
		return null;
	}

}
