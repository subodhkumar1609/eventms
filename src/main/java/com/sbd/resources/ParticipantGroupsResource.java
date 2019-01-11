package com.sbd.resources;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.sbd.db.entity.ParticipantGroups;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;
import com.sbd.handler.ParticipantGroupsHandler;

@Path("/participantsgroup")
@Consumes("application/json")
@Produces("application/json")
public class ParticipantGroupsResource
{
	@Inject
	ParticipantGroupsHandler handler;
	
	@Context UriInfo uriInfo;
	
	@GET
	@Path("/{eventId}")
	public Response getAllParticipantGroups(@PathParam("eventId") Long eventId) throws Exception
	{
		List<Object> list = handler.getAllParticipantGroups(eventId);
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{eventId}/{participantGroupId}")
	public Response getParticipantGroups(@PathParam("eventId") Long eventId, @PathParam("participantGroupId") Long participantGroupId) throws Exception
	{
		ParticipantGroups user = handler.getParticipantGroup(eventId, participantGroupId);
		return Response.ok(user).build();
	}
	
	@POST
	public Response createParticipantGroup(ParticipantGroups participantGroups) throws Exception
	{
		try
		{
			ParticipantGroups newUser = handler.createParticipantGroup(participantGroups);
			URI uri = uriInfo.getAbsolutePathBuilder().path(participantGroups.getId().toString()).build();
			return Response.created(uri).entity(newUser).build();	
		}
		catch (MongoException e) 
		{
			if(e.getErrorCode() == ApplicationConstants.DUPLICATE_COLLECTION)
			{
				return Response.status(Status.CONFLICT).build();
			}
			else
			{
				throw e;
			}
		}
	}
	
	@PUT
	public Response updateParticipantGroup(ParticipantGroups user) throws Exception
	{
		ParticipantGroups newuser = handler.updateParticipantGroup(user);
		return Response.ok(newuser).build();	
	}
}
