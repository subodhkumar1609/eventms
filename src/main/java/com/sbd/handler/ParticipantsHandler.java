package com.sbd.handler;

import java.util.List;

import javax.inject.Inject;

import com.sbd.dao.ParticipantsDAO;
import com.sbd.db.entity.Participants;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;

public class ParticipantsHandler
{
	@Inject
	ParticipantsDAO dao;
	
	@Inject
	ParticipantGroupsHandler participantGroup;
	
	@Inject
	EventsHandler events;
	
	public List<Object> getAllParticipants(Long eventId) throws Exception
	{
		events.isEventExist(eventId);
		return dao.getAllParticipants(eventId);
	}
	
	public Participants getParticipant(Long eventId, Long participantId) throws Exception
	{
		events.isEventExist(eventId);
		
		return dao.getParticipant(eventId, participantId);
	}
	
	public Participants createParticipant(Participants participant) throws Exception
	{
		participantGroup.isGroupExist(participant.getEvent().getId(), participant.getParticipantGroup().getId());
		
		Object existingParticipant = getParticipant(participant.getEvent().getId(), participant.getId());
		if(existingParticipant != null)
		{
			throw new MongoException(ApplicationConstants.DUPLICATE_COLLECTION);
		}
		
		boolean createStatus = dao.createParticipant(participant);
		
		if(createStatus)
		{
			participant = dao.getParticipant(participant.getEvent().getId(), participant.getId());
			return participant;
		}
		return null;
	}
	
	public Participants updateParticipant(Participants participant) throws Exception
	{
		participantGroup.isGroupExist(participant.getEvent().getId(), participant.getParticipantGroup().getId());
		
		Participants existingParticipant = getParticipant(participant.getEvent().getId(), participant.getId());
		
		if(existingParticipant == null)
		{
			throw new MongoException(ApplicationConstants.NOT_EXIST);
		}
		
		boolean status = dao.updateParticipant(participant);
		if(status)
		{
			participant = getParticipant(participant.getEvent().getId(), participant.getId());
		}
		
		return participant;
	}
	
}
