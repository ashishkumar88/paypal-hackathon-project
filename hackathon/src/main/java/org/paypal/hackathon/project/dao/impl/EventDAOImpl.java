package org.paypal.hackathon.project.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.paypal.hackathon.project.dao.EventDAO;
import org.paypal.hackathon.project.persistence.bean.ContentSettings;
import org.paypal.hackathon.project.persistence.bean.EventSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean update(EventSettings eventSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(eventSettings);
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
		return true;
	}

	@Override
	public boolean save(EventSettings eventSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(eventSettings);
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
		return true;
	}

	@Override
	public List<EventSettings> getAllEvents() {
		final Session session = this.sessionFactory.openSession();
		final List<EventSettings> eventSettings = session.createCriteria(EventSettings.class).list();
		session.close();
		return eventSettings;
	}

	@Override
	public EventSettings getEventById(Long id) {
		final Session session = this.sessionFactory.openSession();
		final List<EventSettings> eventSettings = session.createCriteria(ContentSettings.class)
				.add(Restrictions.eq("eventSettingsId", id)).list();
		EventSettings eventSetting = null;
		if(CollectionUtils.isNotEmpty(eventSettings)) {
			eventSetting = eventSettings.get(0);
		}
		session.close();
		return eventSetting;
	}

	@Override
	public boolean deleteEvent(EventSettings eventSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(eventSettings);
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
		return true;
	}

}
