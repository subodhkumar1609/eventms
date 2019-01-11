package com.sbd.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonBean
{
	@JsonProperty("_id")
	private MongoId id;
	
	public MongoId getId()
	{
		return id;
	}
	public void setId(MongoId id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "CommonBean [id=" + id + "]";
	}	
}
