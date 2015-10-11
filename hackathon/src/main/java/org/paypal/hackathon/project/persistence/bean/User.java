package org.paypal.hackathon.project.persistence.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user", catalog = "paypalhackathon")
public class User {

	private Long userId;
	private String gender;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String stateCode;
	private String emailId;
	private String mobileNumber;
	private String password;
	private String zipCode;
	private Date createdDate;
	private Date modifiedDate;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "gender")
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return this.address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return this.address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_code")
	public String getStateCode() {
		return this.stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "email")
	public String getEmailId() {
		return this.emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "mobile")
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "zipcode")
	public String getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
