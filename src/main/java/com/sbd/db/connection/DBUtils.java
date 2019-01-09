package com.sbd.db.connection;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sbd.db.connection.momgoutils.MongoClientProvider;
import com.sbd.db.entity.Events;

public class DBUtils 
{
	public MongoDatabase getDatabase()
	{
		return MongoClientProvider.getInstance().getDatabase(ResourceBundleHandler.getString("DBNAME"));
	}
	
	public MongoCollection<Document> getCollection(String collName)
	{
		return getDatabase().getCollection(collName);
	}
	
	public boolean saveCollection(Object obj)
	{
		
		
		
		return false;
	}
	
	
	public static void getDBConnectionClient()
	{
		MongoClient client = null;
		try
		{
			MongoClientURI uri = new MongoClientURI("");
			
			client = new MongoClient(uri);
			
			MongoDatabase mdb = client.getDatabase("events-dev");
			System.out.println("Connection established...");
			
			
			MongoCollection<Document> collection = mdb.getCollection("events");
			
			System.out.println("Collection recieved --> " + collection);
			
			FindIterable<Document> find = collection.find();
			
			System.out.println("collection.find()  OK");
			
			Document document = new Document("name", "Awesomeness");
			collection.insertOne(document);
			
			System.out.println("insert  OK");
			
			System.out.println(uri.getUsername());
			
			Events events = new Events();
			events.setEventId(1);
			events.setEventName("BIRTHDAY1");
			events.setEventReference("Birthday Bash");
			events.setGroupId(1);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(events);
			
			Document doc = Document.parse(json);
			collection.insertOne(doc);
			
			
			
		//	collection.insertOne(basicDbObject.to);
			
			client.close();		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();				
		}
	}
}
