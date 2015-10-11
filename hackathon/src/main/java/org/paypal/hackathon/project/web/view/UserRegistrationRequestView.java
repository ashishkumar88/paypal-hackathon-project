package org.paypal.hackathon.project.web.view;

import javax.validation.constraints.NotNull;

public class UserRegistrationRequestView {

	@NotNull
	private String gender;

	@NotNull
	private String firstName;
	private String middleName;

	@NotNull
	private String lastName;

	@NotNull
	private String address1;

	@NotNull
	private String address2;

	@NotNull
	private String city;

	@NotNull
	private String stateCode;

	@NotNull
	private String emailId;

	@NotNull
	private String mobileNumber;

	@NotNull
	private String password;

	@NotNull
	private String zipCode;

	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress1() {
		return this.address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return this.address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return this.stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getEmailId() {
		return this.emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "UserRegistrationRequestView [gender=" + this.gender + ", firstName=" + this.firstName + ", middleName="
				+ this.middleName + ", lastName=" + this.lastName + ", address1=" + this.address1 + ", address2=" + this.address2
				+ ", city=" + this.city + ", stateCode=" + this.stateCode + ", emailId=" + this.emailId + ", mobileNumber="
				+ this.mobileNumber + ", password=" + this.password + ", zipCode=" + this.zipCode + "]";
	}


}
