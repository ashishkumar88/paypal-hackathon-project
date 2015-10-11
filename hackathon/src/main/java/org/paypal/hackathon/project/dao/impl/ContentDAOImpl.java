package org.paypal.hackathon.project.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.paypal.hackathon.project.dao.ContentDAO;
import org.paypal.hackathon.project.persistence.bean.ContentSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDAOImpl implements ContentDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ContentSettings> getAllContents() {
		final Session session = this.sessionFactory.openSession();
		final List<ContentSettings> contentSettings = session.createCriteria(ContentSettings.class).list();
		session.close();
		return contentSettings;
	}

	@Override
	public ContentSettings getContentById(Long Id) {
		final Session session = this.sessionFactory.openSession();
		final List<ContentSettings> contentSettings = session.createCriteria(ContentSettings.class)
				.add(Restrictions.eq("contentSettingsId", Id)).list();
		ContentSettings contentSetting = null;
		if(CollectionUtils.isNotEmpty(contentSettings)) {
			contentSetting = contentSettings.get(0);
		}
		session.close();
		return contentSetting;
	}

	@Override
	public ContentSettings getContentById(String Id) {
		final Session session = this.sessionFactory.openSession();
		final List<ContentSettings> contentSettings = session.createCriteria(ContentSettings.class)
				.add(Restrictions.eq("contentId", Id)).list();
		ContentSettings contentSetting = null;
		if(CollectionUtils.isNotEmpty(contentSettings)) {
			contentSetting = contentSettings.get(0);
		}
		session.close();
		return contentSetting;
	}

	@Override
	public boolean save(ContentSettings contentSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(contentSettings);
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

	@Override
	public boolean update(ContentSettings contentSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(contentSettings);
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

	@Override
	public boolean deleteContent(ContentSettings contentSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(contentSettings);
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
