package org.paypal.hackathon.project.web.view;

import javax.validation.constraints.NotNull;

public class LoginRequestView {

	@NotNull
	private String emailId;

	@NotNull
	private String password;

	public String getEmailId() {
		return this.emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequestView [emailId=" + this.emailId + ", password=" + this.password + "]";
	}
}
