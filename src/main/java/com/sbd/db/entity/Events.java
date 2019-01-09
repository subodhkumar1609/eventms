package com.sbd.db.entity;

public class Events
{
	
	private int groupId, eventId;
	private String eventName, eventReference;
	public int getGroupId()
	{
		return groupId;
	}
	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
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
	@Override
	public String toString()
	{
		return "Events [groupId=" + groupId + ", eventId=" + eventId + ", eventName=" + eventName + ", eventReference="
				+ eventReference + "]";
	}
	
}
