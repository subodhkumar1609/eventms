package com.sbd.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.mongodb.BasicDBObject;
import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.Groups;
import com.sbd.db.entity.MongoId;

@RequestScoped
public class GroupsDAO
{
	@Inject
	DBUtils dbUtils;
	
	public List<Object> getGroups(MongoId groupId)
	{
		if(groupId == null)
		{
			return dbUtils.getAllEntity(Groups.class);
		}
		else
		{
			
			BasicDBObject query = new BasicDBObject("_id", groupId);
			return dbUtils.findInCollection(Groups.class, query);
		}
	}

	public boolean createGroup(Groups group)
	{
		return dbUtils.insertCollection(group);
	}
	
	public boolean updateGroup(Groups group)
	{
		return dbUtils.insertCollection(group);
	}

}
