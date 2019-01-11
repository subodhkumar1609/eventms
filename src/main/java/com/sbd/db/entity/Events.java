package com.sbd.db.entity;

import java.util.Date;

public class Events extends CommonBean
{
	private Groups group;
	private String eventName, eventReference, statusId;
	private Date eventDate;
	
	public Groups getGroup()
	{
		return group;
	}
	public void setGroup(Groups group)
	{
		this.group = group;
	}
	public String getEventName()
	{
		return eventName;
	}
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}
	public String getEventReference()
	{
		return eventReference;
	}
	public void setEventReference(String eventReference)
	{
		this.eventReference = eventReference;
	}
	public String getStatusId()
	{
		return statusId;
	}
	public void setStatusId(String statusId)
	{
		this.statusId = statusId;
	}
	public Date getEventDate()
	{
		return eventDate;
	}
	public void setEventDate(Date eventDate)
	{
		this.eventDate = eventDate;
	}
	@Override
	public String toString()
	{
		return "Events [group=" + group + ", eventName=" + eventName + ", eventReference=" + eventReference
				+ ", statusId=" + statusId + ", eventDate=" + eventDate + "]";
	}
}
