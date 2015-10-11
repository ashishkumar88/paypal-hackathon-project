package org.paypal.hackathon.project.persistence.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event_settings", catalog = "paypalhackathon")
@NamedQueries({
	@NamedQuery( name=EventSettings.FIND_EVENT_BY_ID, query="select c from EventSettings c where c.eventSettingsId = :eventSettingsId"),
})
public class EventSettings {

	public static final String FIND_EVENT_BY_ID = "findEventById";

	private Long eventSettingsId;
	private String eventName;
	private Date eventcreationDate;
	private Date eventDate;
	private String eventDetails;
	private User user;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "event_settings_id", unique = true, nullable = false)
	public Long getEventSettingsId() {
		return this.eventSettingsId;
	}

	public void setEventSettingsId(Long eventSettingsId) {
		this.eventSettingsId = eventSettingsId;
	}

	@Column(name = "event_name")
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Column(name = "event_creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEventcreationDate() {
		return this.eventcreationDate;
	}

	public void setEventcreationDate(Date eventcreationDate) {
		this.eventcreationDate = eventcreationDate;
	}

	@Column(name = "event_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Column(name = "event_details")
	public String getEventDetails() {
		return this.eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name="user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
