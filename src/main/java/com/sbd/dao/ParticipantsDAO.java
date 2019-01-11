package com.sbd.dao;

import java.util.List;

import javax.inject.Inject;

import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.Participants;

public class ParticipantsDAO
{
	@Inject
	DBUtils dbutils;
	
	public List<Object> getAllParticipants(Long eventId) throws Exception
	{
		Object[][] queryParams = {{"event._id",eventId}};
		return dbutils.findInCollection(Participants.class, queryParams);
	}
	
	public Participants getParticipant(Long eventId, Long participantId) throws Exception
	{
		Object[][] queryParams = {{"event._id",eventId}, {"_id",participantId}};
		List<Object> objects = dbutils.findInCollection(Participants.class, queryParams);
		return objects == null || objects.isEmpty() ? null : (Participants) objects.get(0);
	}
	
	public boolean createParticipant(Participants participant)
	{
		return dbutils.insertCollection(participant);
	}
	
	public boolean updateParticipant(Participants participant)
	{
		return dbutils.updateCollection(participant);
	}
}
