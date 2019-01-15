package com.sbd.db.connection;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
import com.mongodb.client.model.Filters;
import com.sbd.db.connection.mongoutils.MongoClientProvider;
import com.sbd.db.entity.CommonBean;
import com.sbd.db.utils.CollectionMapper;

public class DBUtils 
{
	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).setSerializationInclusion(Include.NON_NULL);
	
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
	
	public boolean insertCollection(CommonBean obj)
	{
		try
		{
			MongoCollection<Document> collection = getCollection(CollectionMapper.getCollection(obj.getClass()));
			obj.setAuditWhen(System.currentTimeMillis());
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
	
	public List<Object> findInCollection(Class<?> clazz, Object[][] queryParams) throws JsonParseException, JsonMappingException, IOException
	{
		if(queryParams == null)
		{
			return null;
		}
		
		BasicDBObject query = new BasicDBObject();
		for(Object[] params : queryParams)
		{
			query.append((String) params[0], params[1]);
		}
		
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
			obj.setAuditWhen(System.currentTimeMillis());
			collection.updateOne(Filters.eq("_id", obj.getId()), new Document("$set", covertToDocument(obj)));
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCollection(Class<?> clazz, Long id)
	{
		try
		{
			MongoCollection<Document> collection = getCollection(CollectionMapper.getCollection(clazz));
			collection.deleteOne(Filters.eq("_id", id));
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
