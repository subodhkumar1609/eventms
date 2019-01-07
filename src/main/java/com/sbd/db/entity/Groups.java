package com.sbd.db.entity;

public class Groups 
{
	private int groupId;
	private String groupPreference, groupName;
	public int getGroupId()
	{
		return groupId;
	}
	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}
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
		return "Groups [groupId=" + groupId + ", groupPreference=" + groupPreference + ", groupName=" + groupName + "]";
	}
	
	
}
