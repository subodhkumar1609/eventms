package com.sbd.db.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonBean
{
	@JsonProperty("_id")
	private Long id;
	private Date auditWhen;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@JsonProperty
	public Date getAuditWhen()
	{
		return auditWhen;
	}
	
	@JsonIgnore
	public void setAuditWhen(Date auditWhen)
	{
		this.auditWhen = auditWhen;
	}
	
	@Override
	public String toString()
	{
		return "CommonBean [id=" + id + "]";
	}	
}
