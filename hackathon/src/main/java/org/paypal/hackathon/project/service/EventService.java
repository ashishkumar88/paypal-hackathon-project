package org.paypal.hackathon.project.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.paypal.hackathon.project.dao.EventDAO;
import org.paypal.hackathon.project.persistence.bean.EventSettings;
import org.paypal.hackathon.project.persistence.bean.User;
import org.paypal.hackathon.project.utils.PaypalHackathonUtils;
import org.paypal.hackathon.project.web.view.EventRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	EventDAO eventDAO;

	public ResponseStatusView createEvent(EventRequestView eventRequestView) {
		try{
			EventSettings eventSettings = this.mapModelToBean(eventRequestView);
			this.eventDAO.save(eventSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Event has been successfully created.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while creating event.");
			return responseStatusView;
		}
	}

	private EventSettings mapModelToBean(EventRequestView eventRequestView) {
		EventSettings eventSettings = new EventSettings();
		String dateTime = eventRequestView.getEventDate()+" " + eventRequestView.getEventDate();
		eventSettings.setEventDate(PaypalHackathonUtils.convertStringToDate(dateTime, PaypalHackathonUtils.DATE_FORMAT_1));
		eventSettings.setEventDetails(eventRequestView.getEventDescription());
		eventSettings.setEventName(eventRequestView.getEventName());
		if(StringUtils.isNotEmpty(eventRequestView.getEventId())) {
			eventSettings.setEventSettingsId(Long.parseLong(eventRequestView.getEventId()));
		}
		if(eventRequestView.getUserView() != null) {
			User user = new User();
			user.setFirstName(eventRequestView.getUserView().getFirstName());
			user.setMiddleName(eventRequestView.getUserView().getMiddleName());
			user.setLastName(eventRequestView.getUserView().getLastName());
			user.setEmailId(eventRequestView.getUserView().getEmailId());
			user.setMiddleName(eventRequestView.getUserView().getMobileNumber());
		}
		return eventSettings;
	}

	public List<EventSettings> getAllEvents() {
		return this.eventDAO.getAllEvents();
	}

	public EventSettings getEventById(long id) {
		return this.eventDAO.getEventById(id);
	}

	public ResponseStatusView updateEvent(EventRequestView eventRequestView) {
		try{
			EventSettings eventSettings = this.mapModelToBean(eventRequestView);
			this.eventDAO.update(eventSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Event has been successfully updated.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while updating event.");
			return responseStatusView;
		}
	}

	public ResponseStatusView deleteEvent(EventRequestView eventRequestView) {
		try{
			EventSettings eventSettings = this.mapModelToBean(eventRequestView);
			this.eventDAO.deleteEvent(eventSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Event has been successfully deleted.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while deleting event.");
			return responseStatusView;
		}
	}
}
