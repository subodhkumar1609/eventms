package com.sbd.dao;

import java.util.List;

import javax.inject.Inject;

import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.Users;

public class UsersDAO
{
	@Inject
	DBUtils dbutils;

	public List<Object> getAllUsers(long groupId) throws Exception
	{
		Object[][] queryParams = {{"group._id",groupId}};
		return dbutils.findInCollection(Users.class, queryParams);
	}

	public Users getUser(Long groupId, Long userId) throws Exception
	{
		Object[][] queryParams = {{"group._id",groupId}, {"_id",userId}};
		List<Object> users = dbutils.findInCollection(Users.class, queryParams);
		return users == null || users.isEmpty() ? null : (Users) users.get(0);
	}

	public boolean createUser(Users users) throws Exception
	{
		return dbutils.insertCollection(users);
	}

	public boolean updateUser(Users user) throws Exception
	{
		return dbutils.updateCollection(user);
	}
	
}
