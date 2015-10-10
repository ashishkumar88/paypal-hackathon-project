package org.paypal.hackathon.project.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.paypal.hackathon.project.persistence.bean.VendorInformation;
import org.paypal.hackathon.project.service.AngularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngularController {

	@Autowired
	AngularService angularService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		VendorInformation vendorInformation = this.angularService.fetchSingleVendor();
		model.put("id", UUID.randomUUID().toString());
		model.put("vendor", vendorInformation);
		return model;
	}

}
