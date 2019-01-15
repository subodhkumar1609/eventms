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

import com.sbd.db.entity.Users;
import com.sbd.db.utils.ApplicationConstants;
import com.sbd.db.utils.MongoException;
import com.sbd.handler.UsersHandler;

@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class UsersResource
{
	
	@Inject
	UsersHandler handler;
	
	@Context UriInfo uriInfo;
	
	@POST
	@Path("/login")
	public Response processLogin(Users users) throws Exception
	{
		Users user = handler.processLogin(users);
		return Response.ok(user).build();
	}
	
	
	@POST
	@Path("/passchange")
	public Response processPasswordChange(Users users) throws Exception
	{
		Users user = handler.processLogin(users);
		return Response.ok(user).build();
	}	
	
	@GET
	@Path("/{groupId}")
	public Response getAllUsers(@PathParam("groupId") Long groupId) throws Exception
	{
		List<Object> list = handler.getAllUsers(groupId);
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{groupId}/{userId}")
	public Response getUser(@PathParam("groupId") Long groupId, @PathParam("userId") Long userId) throws Exception
	{
		Users user = handler.getUser(groupId, userId);
		return Response.ok(user).build();
	}
	
	@POST
	public Response createUser(Users users) throws Exception
	{
		try
		{
			Users newUser = handler.createUser(users);
			URI uri = uriInfo.getAbsolutePathBuilder().path(users.getId().toString()).build();
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
	public Response updateUser(Users user) throws Exception
	{
		Users newuser = handler.updateUser(user);
		return Response.ok(newuser).build();	
	}
}
