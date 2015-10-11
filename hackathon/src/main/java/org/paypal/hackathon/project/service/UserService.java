package org.paypal.hackathon.project.service;

import java.util.Date;

import org.paypal.hackathon.project.dao.UserDAO;
import org.paypal.hackathon.project.persistence.bean.User;
import org.paypal.hackathon.project.persistence.bean.UserRoles;
import org.paypal.hackathon.project.persistence.bean.Users;
import org.paypal.hackathon.project.web.view.LoginRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.paypal.hackathon.project.web.view.UserRegistrationRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public ResponseStatusView registerUser(UserRegistrationRequestView userRegistrationRequestView) {

		try{
			User user = this.mapModelToBean(userRegistrationRequestView);
			UserRoles userRoles = this.mapModelToBean(user);
			Users users = new Users();
			users.setUsername(user.getEmailId());
			users.setPassword(user.getPassword());
			users.setEnabled(true);
			if(this.userDAO.save(user, userRoles, users)) {
				ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("User has been successfully registered.");
				return responseStatusView;
			} else {
				ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while creating user. Duplicate user name or Server Error.");
				return responseStatusView;
			}
		} catch(Exception e) {
			e.printStackTrace();
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while creating user.");
			return responseStatusView;
		}
	}

	private UserRoles mapModelToBean(User user) {
		UserRoles userRoles = new UserRoles();
		userRoles.setUserName(user.getEmailId());
		return userRoles;
	}

	private User mapModelToBean(UserRegistrationRequestView userRegistrationRequestView) {
		User user = new User();
		user.setFirstName(userRegistrationRequestView.getFirstName());
		user.setMiddleName(userRegistrationRequestView.getMiddleName());
		user.setLastName(userRegistrationRequestView.getLastName());
		user.setGender(userRegistrationRequestView.getGender());
		user.setAddress1(userRegistrationRequestView.getAddress1());
		user.setAddress2(userRegistrationRequestView.getAddress2());
		user.setCity(userRegistrationRequestView.getCity());
		user.setStateCode(userRegistrationRequestView.getStateCode());
		user.setZipCode(userRegistrationRequestView.getZipCode());
		user.setEmailId(userRegistrationRequestView.getEmailId());
		user.setMobileNumber(userRegistrationRequestView.getMobileNumber());
		user.setCreatedDate(new Date());
		user.setModifiedDate(new Date());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userRegistrationRequestView.getPassword()));
		return user;
	}

	public ResponseStatusView loginUser(LoginRequestView loginRequestView) {
		System.out.println(loginRequestView);
		return null;
	}

}
