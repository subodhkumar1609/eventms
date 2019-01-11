package com.sbd.handler;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sbd.dao.GroupsDAO;
import com.sbd.db.entity.Groups;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;

@RequestScoped
public class GroupsHandler
{
	@Inject
	GroupsDAO groupsDao;
	
	/***
	 * 
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public List<Object> getGroups(Long groupId) throws Exception
	{
		return groupsDao.getGroups(groupId);
	}

	public Groups createGroup(Groups group)  throws Exception
	{
		List<Object> groups = null;
		
		if(group.getId() != null)
		{
			groups = groupsDao.getGroups(group.getId());
			if(groups != null && groups.isEmpty() == false)
			{
				throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
			}
		}
		
		boolean groupStatus = groupsDao.createGroup(group);
		
		if(groupStatus)
		{
			groups = groupsDao.getGroups(group.getId());
			return groups == null || groups.isEmpty() ? null : (Groups) groups.get(0);
		}
		return null;
	}

	public Groups updateGroup(Groups group) throws Exception
	{
		List<Object> groups = null;
		
		if(group.getId() != null)
		{
			groups = groupsDao.getGroups(group.getId());
			if(groups == null || groups.isEmpty())
			{
				throw new MongoException(ApplicationConstants.NOT_EXIST);
			}
		}
		
		boolean groupStatus = groupsDao.updateGroup(group);
		
		if(groupStatus)
		{
			groups = groupsDao.getGroups(group.getId());
			return groups == null || groups.isEmpty() ? null : (Groups) groups.get(0);
		}
		return null;
	}

	public boolean deleteGroups(Long groupId) throws JsonParseException, JsonMappingException, IOException
	{
		List<Object> groups = groupsDao.getGroups(groupId);
		if(groups == null || groups.isEmpty())
		{
			return true;
		}
		
		return  groupsDao.deleteGroup(groupId);
	}
}
