package org.paypal.hackathon.project.dao;

import java.util.List;

import org.paypal.hackathon.project.persistence.bean.EventSettings;

public interface EventDAO {

	public boolean save(EventSettings eventSettings);
	public boolean update(EventSettings eventSettings);
	public List<EventSettings> getAllEvents();
	public EventSettings getEventById(Long id);
	public boolean deleteEvent(EventSettings eventSettings);
}
