package com.sbd.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonBean
{
	@JsonProperty("_id")
	private Long id;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "CommonBean [id=" + id + "]";
	}	
}
