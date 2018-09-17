package org.verscend.bbplus.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	private String eventTitle;
	private String eventAddress;

	@Temporal(TemporalType.DATE)
	private Date eventDate;
	private String eventTime;
	@Lob
	private String eventDescription;

	public Event() {
	}

	public Event(int eventId, String eventTitle, String eventAddress, Date eventDate, String eventTime,
			String eventDescription) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventAddress = eventAddress;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventDescription = eventDescription;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

}
