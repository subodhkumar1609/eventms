package com.sbd.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoId
{
	@JsonProperty("$oid")
	private String id;
	
	public MongoId(){}
	
	public MongoId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	
	
}
