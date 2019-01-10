package com.sbd.db.entity;

public class MongoId
{
	private String $oid;
	
	public MongoId(){}
	
	public MongoId(String $oid)
	{
		super();
		this.$oid = $oid;
	}

	public String get$oid()
	{
		return $oid;
	}

	public void set$oid(String $oid)
	{
		this.$oid = $oid;
	}
	
}
