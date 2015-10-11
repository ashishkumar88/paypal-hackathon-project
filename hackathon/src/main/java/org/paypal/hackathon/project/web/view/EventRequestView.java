package org.paypal.hackathon.project.web.view;

public class EventRequestView {

	private String eventId;
	private String eventName;
	private String eventTime;
	private String eventDate;
	private UserView userView;
	private String eventDescription;

	public String getEventId() {
		return this.eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return this.eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventTime() {
		return this.eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventDate() {
		return this.eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public UserView getUserView() {
		return this.userView;
	}
	public void setUserView(UserView userView) {
		this.userView = userView;
	}
	public String getEventDescription() {
		return this.eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
}
