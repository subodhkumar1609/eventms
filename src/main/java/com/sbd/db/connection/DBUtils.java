package com.sbd.db.connection;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBUtils
{
	public static void check()
	{
		String password = "VHhXvRV7UUtVQszq";
		String driver = "mongodb+srv://evappuser:"+password+"@cluster0-igd5v.mongodb.net/test?retryWrites=true";
		MongoClientURI uri = new MongoClientURI(driver);
		
		/*   MongoClientOptions options = MongoClientOptions.builder()
		            .readPreference(ReadPreference.primaryPreferred())
		            .retryWrites(true)
		            .maxConnectionIdleTime(6000)
		            .sslEnabled(true)
		            .build();
*/
		MongoClient client = new MongoClient(uri);
		MongoDatabase mdb = client.getDatabase("events-dev");
		for(String coll : mdb.listCollectionNames())
		{
			System.out.println("MONGO all collections : " + coll);
		}
		MongoCollection<Document> mcoll = mdb.getCollection("events");
		
		System.out.println(uri.getUsername());
		System.out.println(mcoll.find());
		
		for(Document doc : mcoll.find())
		{
			String json = com.mongodb.util.JSON.serialize(doc);
			System.out.println("JSON serialized Document: " + json);
		}
		
		client.close();
		
	}
}
