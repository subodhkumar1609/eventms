package com.sbd.db.entity;

public class ExpenseGroup
{
	private int eventId, expenseGroupId;
	private String name;
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}
	public int getExpenseGroupId()
	{
		return expenseGroupId;
	}
	public void setExpenseGroupId(int expenseGroupId)
	{
		this.expenseGroupId = expenseGroupId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public String toString()
	{
		return "ExpenseGroup [eventId=" + eventId + ", expenseGroupId=" + expenseGroupId + ", name=" + name + "]";
	}
	
}
