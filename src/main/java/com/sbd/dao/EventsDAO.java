package com.sbd.dao;

import java.util.List;
import javax.inject.Inject;
import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.Events;

public class EventsDAO
{
	@Inject
	DBUtils dbutils;

	public List<Object> getAllEvents(long groupId) throws Exception
	{
		Object[][] queryParams = {{"group._id",groupId}};
		return dbutils.findInCollection(Events.class, queryParams);
	}

	public Events getEvent(Long groupId, Long eventId) throws Exception
	{
		Object[][] queryParams = {{"group._id",groupId}, {"_id",eventId}};
		List<Object> events = dbutils.findInCollection(Events.class, queryParams);
		return events == null || events.isEmpty() ? null : (Events) events.get(0);
	}

	public boolean createEvent(Events event) throws Exception
	{
		return dbutils.insertCollection(event);
	}

	public boolean updateEvent(Events event) throws Exception
	{
		return dbutils.updateCollection(event);
	}

	public Events getEvent(Long eventId) throws Exception
	{
		Object[][] queryParams = {{"_id",eventId}};
		List<Object> events = dbutils.findInCollection(Events.class, queryParams);
		return  events == null || events.isEmpty() ? null : (Events) events.get(0);
	}
	
}
