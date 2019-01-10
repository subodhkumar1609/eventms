package com.sbd.handler;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.sbd.dao.GroupsDAO;
import com.sbd.db.entity.Groups;
import com.sbd.db.utils.ApplicationConstants;

@RequestScoped
public class GroupsHandler
{
	@Inject
	GroupsDAO groupsDao;
	
	public List<Object> getGroups(ObjectId groupId)
	{
		return groupsDao.getGroups(groupId);
	}

	public Groups createGroup(Groups group)
	{
		List<Object> groups = groupsDao.getGroups(group.get_id());
		if(groups != null && groups.isEmpty() == false)
		{
			throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
		}
		
		boolean groupStatus = groupsDao.createGroup(group);
		
		if(groupStatus)
		{
			groups = groupsDao.getGroups(group.get_id());
			return groups == null || groups.isEmpty() ? null : (Groups) groups.get(0);
		}
		return null;
	}
}
