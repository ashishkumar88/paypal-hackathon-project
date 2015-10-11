package org.paypal.hackathon.project.dao;

import java.util.List;

import org.paypal.hackathon.project.persistence.bean.EventSettings;

public interface EventDAO {

	public void save(EventSettings eventSettings);
	public void update(EventSettings eventSettings);
	public List<EventSettings> getAllEvents();
	public EventSettings getEventById(Long id);
	public void deleteEvent(EventSettings eventSettings);
}
