package com.sbd.db.entity;

public class Groups extends CommonBean
{	
	private String groupPreference, groupName;
	
	public String getGroupPreference()
	{
		return groupPreference;
	}
	public void setGroupPreference(String groupPreference)
	{
		this.groupPreference = groupPreference;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	@Override
	public String toString()
	{
		return "Groups [_id=" + getId() + ", groupPreference=" + groupPreference + ", groupName="
				+ groupName + "]";
	}
	
}
