package com.sbd.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sbd.db.connection.DBUtils;

@Path("/groups")
@Consumes("application/json")
@Produces("application/json")
public class GroupsResource 
{
	@GET
	public Response getGroups()
	{
		DBUtils.check();
		
		Map<String, String> check = new HashMap<String, String>();
		check.put("check", "this");
		return Response.ok().entity(check).build();
		
	}
	
}
