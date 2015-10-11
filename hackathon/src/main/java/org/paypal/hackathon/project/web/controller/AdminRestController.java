package org.paypal.hackathon.project.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.paypal.hackathon.project.persistence.bean.ContentSettings;
import org.paypal.hackathon.project.persistence.bean.EventSettings;
import org.paypal.hackathon.project.persistence.bean.JobSettings;
import org.paypal.hackathon.project.service.AngularService;
import org.paypal.hackathon.project.service.ContentService;
import org.paypal.hackathon.project.service.EventService;
import org.paypal.hackathon.project.service.JobService;
import org.paypal.hackathon.project.web.view.ContentRequestView;
import org.paypal.hackathon.project.web.view.EventRequestView;
import org.paypal.hackathon.project.web.view.JobRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

	@Autowired
	AngularService angularService;

	@Autowired
	JobService jobService;

	@Autowired
	ContentService contentService;

	@Autowired
	EventService eventService;

	/**
	 * Rest Endpoint for jobs
	 * @param jobRequestView
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/job/create", method = RequestMethod.POST)
	public Map<String,Object> createJob(@RequestBody  JobRequestView jobRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.jobService.createJob(jobRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/job/viewall", method = RequestMethod.POST)
	public Map<String,Object> viewAllJobs(@RequestBody  JobRequestView jobRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		List<JobSettings> jobs = this.jobService.getAllJobs(jobRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("jobs", jobs);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/job/view", method = RequestMethod.POST)
	public Map<String,Object> viewJob(@RequestBody  JobRequestView jobRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		JobSettings job = this.jobService.getJobById(jobRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("job", job);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/job/update", method = RequestMethod.POST)
	public Map<String,Object> updateJob(@RequestBody  JobRequestView jobRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.jobService.updateJob(jobRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/job/delete", method = RequestMethod.POST)
	public Map<String,Object> deleteJob(@RequestBody  JobRequestView jobRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.jobService.deleteJob(jobRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}


	/**
	 * Rest endpoint for contents
	 * @param contentRequestView
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/content/create", method = RequestMethod.POST)
	public Map<String,Object> createContent(@RequestBody  ContentRequestView contentRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.contentService.createContent(contentRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/content/viewall", method = RequestMethod.POST)
	public Map<String,Object> getAllContents(@RequestBody  ContentRequestView contentRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		List<ContentSettings> contents = this.contentService.getAllContents();
		model.put("id", UUID.randomUUID().toString());
		model.put("contents", contents);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/content/view", method = RequestMethod.POST)
	public Map<String,Object> viewJob(@RequestBody  ContentRequestView contentRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ContentSettings content = this.contentService.getContentById(Long.parseLong(contentRequestView.getContentSettingsId()));
		model.put("id", UUID.randomUUID().toString());
		model.put("content", content);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/content/update", method = RequestMethod.POST)
	public Map<String,Object> updateJob(@RequestBody  ContentRequestView contentRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.contentService.updateContent(contentRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/content/delete", method = RequestMethod.POST)
	public Map<String,Object> deleteJob(@RequestBody  ContentRequestView contentRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.contentService.deleteContent(contentRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	/**
	 * Rest endpoint for events
	 * @param contentRequestView
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/event/create", method = RequestMethod.POST)
	public Map<String,Object> createEvent(@RequestBody  EventRequestView eventRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.eventService.createEvent(eventRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/event/viewall", method = RequestMethod.POST)
	public Map<String,Object> getAllContents(@RequestBody  EventRequestView eventRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		List<EventSettings> events = this.eventService.getAllEvents();
		model.put("id", UUID.randomUUID().toString());
		model.put("events", events);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/event/view", method = RequestMethod.POST)
	public Map<String,Object> viewJob(@RequestBody  EventRequestView eventRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		EventSettings event = this.eventService.getEventById(Long.parseLong(eventRequestView.getEventId()));
		model.put("id", UUID.randomUUID().toString());
		model.put("event", event);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/event/update", method = RequestMethod.POST)
	public Map<String,Object> updateJob(@RequestBody  EventRequestView eventRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.eventService.updateEvent(eventRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/admin/event/delete", method = RequestMethod.POST)
	public Map<String,Object> deleteJob(@RequestBody  EventRequestView eventRequestView) {
		Map<String,Object> model = new HashMap<String,Object>();
		ResponseStatusView responseStatusView = this.eventService.deleteEvent(eventRequestView);
		model.put("id", UUID.randomUUID().toString());
		model.put("response", responseStatusView);
		return model;
	}
}
