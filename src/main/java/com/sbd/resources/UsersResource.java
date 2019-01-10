package com.sbd.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mongodb.MongoClientURI;

@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class UsersResource
{
	@GET
	public Response getGroups()
	{
		System.out.println("Get users");
		
		String password = "VHhXvRV7UUtVQszq";
		String driver = "mongodb+srv://evappuser:"+password+"@cluster0-sjzzr.mongodb.net/events-dev?retrywrites=true";
		MongoClientURI uri = new MongoClientURI(driver);
		
		//MongoClient client = null;
		
		return Response.ok().build();
	}
}
