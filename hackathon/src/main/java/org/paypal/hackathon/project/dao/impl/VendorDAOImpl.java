package org.paypal.hackathon.project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.paypal.hackathon.project.persistence.bean.VendorInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VendorDAOImpl {

	@PersistenceContext
	EntityManager entityManager;

	public VendorInformation fetchSingleVendor() {
		return this.entityManager.createQuery("from VendorInformation", VendorInformation.class).getSingleResult();
	}

}
