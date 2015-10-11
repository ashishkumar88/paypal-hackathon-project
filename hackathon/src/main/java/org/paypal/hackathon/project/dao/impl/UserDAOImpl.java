package org.paypal.hackathon.project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.paypal.hackathon.project.dao.UserDAO;
import org.paypal.hackathon.project.persistence.bean.User;
import org.paypal.hackathon.project.persistence.bean.UserRoles;
import org.paypal.hackathon.project.persistence.bean.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(User user, UserRoles userRoles, Users users) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(user);
			session.saveOrUpdate(users);
			session.saveOrUpdate(userRoles);
			tx.commit();
			return true;
		} catch (final Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return false;
	}
}
