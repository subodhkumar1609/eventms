package com.sbd.db.entity;

import org.bson.types.ObjectId;

public class Groups 
{
	private ObjectId _id;
	//private int groupId;
	private String groupPreference, groupName;
	
	public ObjectId get_id()
	{
		return _id;
	}
	public void set_id(ObjectId _id)
	{
		this._id = _id;
	}
	/*public int getGroupId()
	{
		return groupId;
	}
	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}*/
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
