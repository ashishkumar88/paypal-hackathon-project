package org.paypal.hackathon.project.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.paypal.hackathon.project.persistence.bean.ContentSettings;
import org.paypal.hackathon.project.service.ContentService;
import org.paypal.hackathon.project.web.view.ContentRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralRestController {

	@Autowired
	ContentService contentService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/contents/all", method=RequestMethod.POST)
	public Map<String,Object> getAllContents(@RequestBody ContentRequestView contentRequestView){
		Map<String,Object> model = new HashMap<String,Object>();
		List<ContentSettings> contents = this.contentService.getAllContents();
		model.put("id", UUID.randomUUID().toString());
		model.put("contents", contents);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/contents/id", method=RequestMethod.POST)
	public Map<String,Object> getContentById(@RequestBody ContentRequestView contentRequestView){
		Map<String,Object> model = new HashMap<String,Object>();
		ContentSettings content = this.contentService.getContentById(Long.parseLong(contentRequestView.getContentSettingsId()));
		model.put("id", UUID.randomUUID().toString());
		model.put("content", content);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/contents/sid", method=RequestMethod.POST)
	public Map<String,Object> getContentByStringId(@RequestBody ContentRequestView contentRequestView){
		Map<String,Object> model = new HashMap<String,Object>();
		ContentSettings content = this.contentService.getContentById(contentRequestView.getContentId());
		model.put("id", UUID.randomUUID().toString());
		model.put("content", content);
		return model;
	}
}
