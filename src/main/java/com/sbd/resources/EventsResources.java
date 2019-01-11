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

import com.sbd.db.entity.Events;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;
import com.sbd.handler.EventsHandler;

@Path("/events")
@Consumes("application/json")
@Produces("application/json")
public class EventsResources
{
	@Inject
	EventsHandler handler;
	
	@Context UriInfo uriInfo;
	
	@GET
	@Path("/{groupId}")
	public Response getAllEvents(@PathParam("groupId") Long groupId) throws Exception
	{
		List<Object> list = handler.getAllEvents(groupId);
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{groupId}/{eventId}")
	public Response getEvents(@PathParam("groupId") Long groupId, @PathParam("eventId") Long eventId) throws Exception
	{
		Events user = handler.getEvent(groupId, eventId);
		return Response.ok(user).build();
	}
	
	@POST
	public Response createEvent(Events events) throws Exception
	{
		try
		{
			Events newUser = handler.createEvent(events);
			URI uri = uriInfo.getAbsolutePathBuilder().path(events.getId().toString()).build();
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
	public Response updateEvent(Events user) throws Exception
	{
		Events newuser = handler.updateEvent(user);
		return Response.ok(newuser).build();	
	}
}
