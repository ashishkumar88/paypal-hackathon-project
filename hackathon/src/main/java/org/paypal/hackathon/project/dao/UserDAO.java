package org.paypal.hackathon.project.dao;

import org.paypal.hackathon.project.persistence.bean.User;
import org.paypal.hackathon.project.persistence.bean.UserRoles;
import org.paypal.hackathon.project.persistence.bean.Users;

public interface UserDAO {
	public boolean save(User user, UserRoles userRoles, Users users);
}
