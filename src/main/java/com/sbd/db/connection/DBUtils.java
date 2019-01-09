package com.sbd.db.connection;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sbd.db.entity.Test;

public class DBUtils
{
	public static void check()
	{
		MongoClient client = null;
		try
		{
			String password = "VHhXvRV7UUtVQszq";
			String driver = "mongodb+srv://evappuser:"+password+"@cluster0-igd5v.mongodb.net/test?retryWrites=true";
			//String driver = "mongodb://evappuser:"+password+"@cluster0-shard-00-00-igd5v.mongodb.net:27017,cluster0-shard-00-01-igd5v.mongodb.net:27017,cluster0-shard-00-02-igd5v.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin";
			MongoClientURI uri = new MongoClientURI(driver);
			
			/*   MongoClientOptions options = MongoClientOptions.builder()
			            .readPreference(ReadPreference.primaryPreferred())
			            .retryWrites(true)
			            .maxConnectionIdleTime(6000)
			            .sslEnabled(true)
			            .build();
	*/
			client = new MongoClient(uri);
			
			System.out.println("Getting DB");
			MongoDatabase mdb = client.getDatabase("events-dev");
			System.out.println("Connection established...");
			
			
			MongoCollection<Document> collection = mdb.getCollection("events");
			
			System.out.println("Collection recieved --> " + collection);
			
			FindIterable<Document> find = collection.find();
			
			System.out.println("collection.find()  OK");
			
			/*MongoCursor<Document> iterator = find.iterator();
			
			System.out.println("find.iterator()  OK");

			while (iterator.hasNext()) {
				Document document = iterator.next();
				System.out.println(document);
				Test t = new Test();
				t.set_id(document.get("_id", org.bson.types.ObjectId.class));
				t.setName(document.get("name", String.class));
				System.out.println("Document -->  " + t);
			}
*/
			Document document = new Document("name", "Awesomeness");
			collection.insertOne(document);
			
			System.out.println("insert  OK");
			
			/*System.out.println("Getting DB :: " + mdb.getName());
			for(String coll : mdb.listCollectionNames())
			{
				System.out.println("MONGO all collections : " + coll);
			}*/
		//	System.out.println("Getting collections :: " + mdb.getCollection("events"));
		//	MongoCollection<Document> mcoll = mdb.getCollection("events");
			
			System.out.println(uri.getUsername());
			/*System.out.println(mcoll.find());
			
			for(Document doc : mcoll.find())
			{
				String json = com.mongodb.util.JSON.serialize(doc);
				System.out.println("JSON serialized Document: " + json);
			}*/
			
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
