package com.sbd.db.entity;

public class Groups 
{
	private MongoId _id;
	
	//private int groupId;
	private String groupPreference, groupName;
	
	public MongoId get_id()
	{
		return _id;
	}
	public void set_id(MongoId _id)
	{
		this._id = _id;
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
		return "Groups [_id=" + _id + ", groupPreference=" + groupPreference + ", groupName="
				+ groupName + "]";
	}
	
	
}
