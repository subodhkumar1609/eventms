package com.sbd.db.entity;

public class ParticipantGroups
{
	private int eventId, groupId;
	private String name, remarks;
	private long amount;
		
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}
	public int getGroupId()
	{
		return groupId;
	}
	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	
	public long getAmount()
	{
		return amount;
	}
	public void setAmount(long amount)
	{
		this.amount = amount;
	}
	@Override
	public String toString()
	{
		return "ParticipantGroups [eventId=" + eventId + ", groupId=" + groupId + ", name=" + name + ", remarks="
				+ remarks + ", amount=" + amount + "]";
	}
	
}
