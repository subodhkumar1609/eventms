package com.sbd.db.connection;

import java.util.Arrays;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sbd.db.entity.Events;
import com.sbd.db.entity.Test;

public class DBUtils 
{
	public static void check()
	{
		MongoClient client = null;
		try
		{
			
		/*	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		*/	
			
			String password = "VHhXvRV7UUtVQszq";
			String driver = "mongodb+srv://evappuser:"+password+"@cluster0-igd5v.mongodb.net/events-dev?retryWrites=true";
			MongoClientURI uri = new MongoClientURI(driver);
			
			client = new MongoClient(uri);
		
			System.out.println("Getting DB");
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
