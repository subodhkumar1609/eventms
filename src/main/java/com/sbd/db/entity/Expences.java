package com.sbd.db.entity;

public class Expences
{
	private int id, eventId, userId, expenseGroupId, expenseType, settlementFlag;
	private String expenseDetails, remarks;
	private double amount;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getExpenseGroupId()
	{
		return expenseGroupId;
	}
	public void setExpenseGroupId(int expenseGroupId)
	{
		this.expenseGroupId = expenseGroupId;
	}
	public int getExpenseType()
	{
		return expenseType;
	}
	public void setExpenseType(int expenseType)
	{
		this.expenseType = expenseType;
	}
	public int getSettlementFlag()
	{
		return settlementFlag;
	}
	public void setSettlementFlag(int settlementFlag)
	{
		this.settlementFlag = settlementFlag;
	}
	public String getExpenseDetails()
	{
		return expenseDetails;
	}
	public void setExpenseDetails(String expenseDetails)
	{
		this.expenseDetails = expenseDetails;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	@Override
	public String toString()
	{
		return "Expences [id=" + id + ", eventId=" + eventId + ", userId=" + userId + ", expenseGroupId="
				+ expenseGroupId + ", expenseType=" + expenseType + ", settlementFlag=" + settlementFlag
				+ ", expenseDetails=" + expenseDetails + ", remarks=" + remarks + ", amount=" + amount + "]";
	}
	
}	
