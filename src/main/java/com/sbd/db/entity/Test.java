package com.sbd.db.entity;

public class Test 
{
	private org.bson.types.ObjectId _id;
	private String name;
	
	public org.bson.types.ObjectId get_id() {
		return _id;
	}
	public void set_id(org.bson.types.ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Test [_id=" + _id + ", name=" + name + "]";
	}
}
