package com.sbd.dao;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.BasicDBObject;
import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.Groups;

@RequestScoped
public class GroupsDAO
{
	@Inject
	DBUtils dbUtils;
	
	public List<Object> getGroups(Long groupId) throws JsonParseException, JsonMappingException, IOException
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
