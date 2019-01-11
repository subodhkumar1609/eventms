package com.sbd.db.connection;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sbd.db.connection.mongoutils.MongoClientProvider;
import com.sbd.db.entity.CommonBean;
import com.sbd.db.utils.CollectionMapper;

public class DBUtils 
{
	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public MongoDatabase getDatabase()
	{
		return MongoClientProvider.getInstance().getDatabase(ResourceBundleHandler.getString("DBNAME"));
	}
	
	public MongoCollection<Document> getCollection(String collName)
	{
		return getDatabase().getCollection(collName);
	}
	
	public MongoCollection<Document> getCollection(Class<?> clazz)
	{
		return getDatabase().getCollection(CollectionMapper.getCollection(clazz));
	}
	
	public boolean insertCollection(Object obj)
	{
		try
		{
			MongoCollection<Document> collection = getCollection(CollectionMapper.getCollection(obj.getClass()));
			collection.insertOne(covertToDocument(obj));
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Object> getAllEntity(Class<?> clazz) throws JsonParseException, JsonMappingException, IOException
	{
		MongoCollection<Document> collection = getCollection(clazz);
		FindIterable<Document> find = collection.find();
		MongoCursor<Document> iterator = find.iterator();
		List<Object> list = new ArrayList<>();
		while (iterator.hasNext()) 
		{
			Document document = iterator.next();
			list.add(mapper.readValue(document.toJson(), clazz));
		}
		return list;
	}
	
	public Document covertToDocument(Object obj) throws JsonProcessingException
	{
		return Document.parse(mapper.writeValueAsString(obj));
	}

	public List<Object> findInCollection(Class<?> clazz, BasicDBObject query) throws JsonParseException, JsonMappingException, IOException
	{
		MongoCollection<Document> collection = getCollection(clazz);
		FindIterable<Document> find = collection.find(query);
		MongoCursor<Document> iterator = find.iterator();
		List<Object> list = new ArrayList<>();
		while (iterator.hasNext()) 
		{
			Document document = iterator.next();
			list.add(mapper.readValue(document.toJson(), clazz));
		}
		return list;
	}

	public boolean updateCollection(CommonBean obj)
	{
		try
		{
			MongoCollection<Document> collection = getCollection(CollectionMapper.getCollection(obj.getClass()));
			BasicDBObject searchQuery = new BasicDBObject().append("_id", obj.getId());
			collection.updateOne(searchQuery, covertToDocument(obj));
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
