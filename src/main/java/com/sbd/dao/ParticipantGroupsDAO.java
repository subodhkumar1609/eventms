package com.sbd.dao;

import java.util.List;

import javax.inject.Inject;

import com.sbd.db.connection.DBUtils;
import com.sbd.db.entity.ParticipantGroups;

public class ParticipantGroupsDAO
{
	@Inject
	DBUtils dbutils;

	public List<Object> getAllParticipantGroups(Long eventId) throws Exception
	{
		Object[][] queryParams = {{"event._id",eventId}};
		return dbutils.findInCollection(ParticipantGroups.class, queryParams);
	}

	public ParticipantGroups getParticipantGroup(Long eventId, Long participantGroupId) throws Exception
	{
		Object[][] queryParams = {{"event._id",eventId}, {"_id",participantGroupId}};
		List<Object> objects = dbutils.findInCollection(ParticipantGroups.class, queryParams);
		return objects == null || objects.isEmpty() ? null : (ParticipantGroups) objects.get(0);
	}

	public boolean createParticipantGroup(ParticipantGroups participantGroup)
	{
		return dbutils.insertCollection(participantGroup);
	}

	public boolean updateParticipantGroup(ParticipantGroups participantGroup)
	{
		return dbutils.updateCollection(participantGroup);
	}
}
