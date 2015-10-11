package org.paypal.hackathon.project.persistence.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles", catalog = "paypalhackathon")
public class UserRoles {

	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	private Long userRoleId;
	private String userName;
	private String role = ROLE_USER;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_role_id", unique = true, nullable = false)
	public Long getUserRoleId() {
		return this.userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "username")
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "role")
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
