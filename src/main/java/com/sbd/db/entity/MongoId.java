package com.sbd.db.entity;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoId
{
	@JsonProperty("$oid")
	private String id;
	
	@JsonIgnore
	private ObjectId _id;
	
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
		_id = new ObjectId(id);
	}
	
	public ObjectId get_id()
	{
		if(_id == null && id != null)
			_id = new ObjectId(id);
		
		return _id;
	}
	
	public void set_id(ObjectId _id)
	{
		this._id = _id;
	}

	@Override
	public String toString()
	{
		return "MongoId [id=" + id + "]";
	}	
}
