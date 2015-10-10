package org.paypal.hackathon.project.service;

import org.paypal.hackathon.project.dao.VendorDAO;
import org.paypal.hackathon.project.persistence.bean.VendorInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AngularService {

	@Autowired
	VendorDAO vendorDAO;

	public VendorInformation fetchSingleVendor() {
		return this.vendorDAO.fetchSingleVendor();
	}

}
