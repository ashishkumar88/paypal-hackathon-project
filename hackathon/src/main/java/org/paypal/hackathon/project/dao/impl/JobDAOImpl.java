package org.paypal.hackathon.project.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.paypal.hackathon.project.dao.JobDAO;
import org.paypal.hackathon.project.persistence.bean.JobSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobDAOImpl implements JobDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(JobSettings jobSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(jobSettings);
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
	public boolean update(JobSettings jobSettings) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(jobSettings);
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
	public List<JobSettings> getAllJobs() {
		final Session session = this.sessionFactory.openSession();
		final List<JobSettings> jobSettings = session.createCriteria(JobSettings.class).list();
		session.close();
		return jobSettings;
	}

	@Override
	public JobSettings getJobById(Long id) {
		final Session session = this.sessionFactory.openSession();
		final List<JobSettings> jobSettings = session.createCriteria(JobSettings.class)
				.add(Restrictions.eq("jobSettingsId", id)).list();
		JobSettings jobSetting = null;
		if(CollectionUtils.isNotEmpty(jobSettings)) {
			jobSetting = jobSettings.get(0);
		}
		session.close();
		return jobSetting;
	}

	@Override
	public boolean deleteJob(JobSettings job) {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(job);
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
