package com.sbd.resources;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.bson.types.ObjectId;

import com.sbd.db.entity.Groups;
import com.sbd.handler.GroupsHandler;

@Path("/groups")
@Consumes("application/json")
@Produces("application/json")
public class GroupsResource 
{
	@Inject
	GroupsHandler handler;
	
	@GET
	public Response getGroups()
	{
		List<Object> list = handler.getGroups(null);
		if(list == null || list.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(list).build();
	}
	
	@GET
	@Path("/{groupId}")
	public Response getGroups(@PathParam("groupId") String groupId)
	{
		ObjectId objId = new ObjectId(groupId);
		List<Object> list = handler.getGroups(objId);
		if(list == null || list.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(list).build();
	}
	
	@POST
	public Response createGroup(Groups group, @Context UriInfo uriInfo)
	{
		Groups newGroup = handler.createGroup(group);
		URI uri = uriInfo.getAbsolutePathBuilder().path(newGroup.get_id().toString()).build();
		return Response.created(uri).entity(newGroup).build();
	}

	
}
