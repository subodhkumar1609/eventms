package com.sbd.handler;

import java.util.List;

import javax.inject.Inject;

import com.sbd.dao.ParticipantGroupsDAO;
import com.sbd.db.entity.ParticipantGroups;
import com.sbd.db.utils.AppException;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;

public class ParticipantGroupsHandler
{
	@Inject
	ParticipantGroupsDAO dao;
	
	@Inject
	EventsHandler events;
	
	public List<Object> getAllParticipantGroups(Long eventId) throws Exception
	{
		events.isEventExist(eventId);
		return dao.getAllParticipantGroups(eventId);
	}

	public ParticipantGroups getParticipantGroup(Long eventId, Long participantGroupId) throws Exception
	{
		events.isEventExist(eventId);
		
		return dao.getParticipantGroup(eventId, participantGroupId);
	}

	public ParticipantGroups createParticipantGroup(ParticipantGroups participantGroups) throws Exception
	{
		Object existingParticipantGroup = getParticipantGroup(participantGroups.getEvent().getId(), participantGroups.getId());
		if(existingParticipantGroup != null)
		{
			throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
		}
		
		boolean createStatus = dao.createParticipantGroup(participantGroups);
		
		if(createStatus)
		{
			existingParticipantGroup = dao.getParticipantGroup(participantGroups.getEvent().getId(), participantGroups.getId());
			return (ParticipantGroups) existingParticipantGroup;
		}
		
		return null;
	}

	public ParticipantGroups updateParticipantGroup(ParticipantGroups participantGroups) throws Exception
	{
		ParticipantGroups existingparticipantGroups = getParticipantGroup(participantGroups.getEvent().getId(), participantGroups.getId());
		if(existingparticipantGroups == null)
		{
			throw new MongoException(ApplicationConstants.NOT_EXIST);
		}
		
		boolean status = dao.updateParticipantGroup(participantGroups);
		if(status)
		{
			participantGroups = dao.getParticipantGroup(participantGroups.getEvent().getId(), participantGroups.getId());
		}
		
		return participantGroups;
	}

	public boolean isGroupExist(Long eventId, Long participantGroupId) throws Exception
	{
		ParticipantGroups group = getParticipantGroup(eventId, participantGroupId);
		if(group == null)
		{
			throw new AppException(ApplicationConstants.PARTICIPANTGROUP_NOT_AVAILABLE);
		}
		return true;
	}

}
