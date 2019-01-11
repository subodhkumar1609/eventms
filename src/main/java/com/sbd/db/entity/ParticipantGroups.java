package com.sbd.db.entity;

public class ParticipantGroups extends CommonBean
{
	private Events event;
	private String name, remarks;
	private long amount;
	
	public Events getEvent()
	{
		return event;
	}
	public void setEvent(Events event)
	{
		this.event = event;
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
		return "ParticipantGroups [event=" + event + ", name=" + name + ", remarks=" + remarks + ", amount=" + amount
				+ "]";
	}
}
