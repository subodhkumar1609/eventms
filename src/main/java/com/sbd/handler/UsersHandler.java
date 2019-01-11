package com.sbd.handler;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sbd.dao.UsersDAO;
import com.sbd.db.entity.Users;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;

@RequestScoped
public class UsersHandler
{
	@Inject
	UsersDAO dao;
	
	@Inject
	GroupsHandler groupHandler;
	
	public List<Object> getAllUsers(long groupId) throws Exception
	{
		groupHandler.isGroupExist(groupId);
		
		return dao.getAllUsers(groupId);
	}

	public Users getUser(Long groupId, Long userId) throws Exception 
	{
		groupHandler.isGroupExist(groupId);
		
		return dao.getUser(groupId, userId);
	}

	public Users createUser(Users users) throws Exception 
	{
		Object existingUser = getUser(users.getGroup().getId(), users.getId());
		if(existingUser != null)
		{
			throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
		}
		
		boolean createUserStatus = dao.createUser(users);
		
		if(createUserStatus)
		{
			existingUser = dao.getUser(users.getGroup().getId(), users.getId());
			return (Users) existingUser;
		}
		
		return null;
	}

	public Users updateUser(Users user) throws Exception
	{
		Users existingUser = getUser(user.getGroup().getId(), user.getId());
		if(existingUser == null)
		{
			throw new MongoException(ApplicationConstants.NOT_EXIST);
		}
		
		boolean status = dao.updateUser(user);
		if(status)
		{
			user = getUser(user.getGroup().getId(), user.getId());
		}
		
		return user;
	}
	
}
