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

import com.sbd.db.entity.Participants;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;
import com.sbd.handler.ParticipantsHandler;

@Path("/participants")
@Consumes("application/json")
@Produces("application/json")
public class ParticipantsResources
{
	@Inject
	ParticipantsHandler handler;
	
	@Context UriInfo uriInfo;
	
	@GET
	@Path("/{eventId}")
	public Response getAllParticipant(@PathParam("eventId") Long eventId) throws Exception
	{
		List<Object> list = handler.getAllParticipants(eventId);
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{eventId}/{participantId}")
	public Response getParticipant(@PathParam("eventId") Long eventId, @PathParam("participantId") Long participantId) throws Exception
	{
		Participants user = handler.getParticipant(eventId, participantId);
		return Response.ok(user).build();
	}
	
	@POST
	public Response createParticipantGroup(Participants participant) throws Exception
	{
		try
		{
			Participants newUser = handler.createParticipant(participant);
			URI uri = uriInfo.getAbsolutePathBuilder().path(participant.getId().toString()).build();
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
	public Response updateParticipantGroup(Participants user) throws Exception
	{
		Participants newuser = handler.updateParticipant(user);
		return Response.ok(newuser).build();	
	}
}
