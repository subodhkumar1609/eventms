package com.sbd.db.entity;

public class Parameters
{
	private int eventId, paramId;
	private String name, paramValue;
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}
	public int getParamId()
	{
		return paramId;
	}
	public void setParamId(int paramId)
	{
		this.paramId = paramId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getParamValue()
	{
		return paramValue;
	}
	public void setParamValue(String paramValue)
	{
		this.paramValue = paramValue;
	}
	@Override
	public String toString()
	{
		return "Parameters [eventId=" + eventId + ", paramId=" + paramId + ", name=" + name + ", paramValue="
				+ paramValue + "]";
	}
	
}
