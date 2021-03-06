package com.sbd.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.sbd.db.entity.Groups;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;
import com.sbd.handler.GroupsHandler;

@Path("/groups")
@Consumes("application/json")
@Produces("application/json")
public class GroupsResource 
{
	@Inject
	GroupsHandler handler;
	
	@Context UriInfo uriInfo;
	
	@GET
	public Response getGroups() throws Exception
	{
		//List<Object> list = handler.getGroups(null);
		List<Object> list = new ArrayList<Object>();
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("name", "Subodh");
		list.add(mp);
		
		System.out.println(list);
		
		if(list == null || list.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(list).build();
	}
	
	@DELETE
	@Path("/{groupId}")
	public Response deleteGroups(@PathParam("groupId") Long groupId) throws Exception
	{
		boolean isSuccess = handler.deleteGroups(groupId);
		if(isSuccess)
			return Response.noContent().build();
		else
			return Response.serverError().build();
	}
	
	@GET
	@Path("/{groupId}")
	public Response getGroup(@PathParam("groupId") Long groupId) throws Exception
	{
		List<Object> list = handler.getGroups(groupId);
		if(list == null || list.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(list.get(0)).build();
	}
	
	@POST
	public Response createGroup(Groups group) throws Exception
	{
		try
		{
			Groups newGroup = handler.createGroup(group);
			URI uri = uriInfo.getAbsolutePathBuilder().path(newGroup.getId().toString()).build();
			return Response.created(uri).entity(newGroup).build();	
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
	public Response updateGroup(Groups group) throws Exception
	{
		Groups newGroup = handler.updateGroup(group);
		return Response.ok(newGroup).build();	
	}

	
}
