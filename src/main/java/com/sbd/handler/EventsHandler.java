package com.sbd.handler;

import java.util.List;

import javax.inject.Inject;

import com.sbd.dao.EventsDAO;
import com.sbd.db.entity.Events;
import com.sbd.db.utils.AppException;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;

public class EventsHandler
{
	@Inject
	EventsDAO dao;
	
	@Inject
	GroupsHandler groupHandler;
	
	public List<Object> getAllEvents(long groupId) throws Exception
	{
		groupHandler.isGroupExist(groupId);
		
		return dao.getAllEvents(groupId);
	}

	public Events getEvent(Long groupId, Long eventId) throws Exception 
	{
		groupHandler.isGroupExist(groupId);
		
		return dao.getEvent(groupId, eventId);
	}
	
	public Events getEvent(Long eventId) throws Exception 
	{
		return dao.getEvent(eventId);
	}

	public Events createEvent(Events events) throws Exception 
	{
		Object existingEvent = getEvent(events.getGroup().getId(), events.getId());
		if(existingEvent != null)
		{
			throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
		}
		
		boolean createEventstatus = dao.createEvent(events);
		
		if(createEventstatus)
		{
			existingEvent = dao.getEvent(events.getGroup().getId(), events.getId());
			return (Events) existingEvent;
		}
		
		return null;
	}

	public Events updateEvent(Events event) throws Exception
	{
		Events existingEvent = getEvent(event.getGroup().getId(), event.getId());
		
		if(existingEvent == null)
		{
			throw new MongoException(ApplicationConstants.NOT_EXIST);
		}
		
		boolean status = dao.updateEvent(event);
		if(status)
		{
			event = getEvent(event.getGroup().getId(), event.getId());
		}
		
		return event;
	}

	public boolean isEventExist(Long eventId) throws Exception
	{
		Events events = getEvent(eventId);
		if(events == null)
		{
			throw new AppException(ApplicationConstants.EVENT_NOT_AVAILABLE);
		}
		return true;
	}
}
