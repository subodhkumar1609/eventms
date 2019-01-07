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
	public static void main(String [] args)
	{
		String password = "VHhXvRV7UUtVQszq";
		String driver = "mongodb+srv://evappuser:"+password+"@cluster0-igd5v.mongodb.net/test?retryWrites=true";
		MongoClientURI uri = new MongoClientURI(driver);
		
		   MongoClientOptions options = MongoClientOptions.builder()
		            .readPreference(ReadPreference.primaryPreferred())
		            .retryWrites(true)
		            .maxConnectionIdleTime(6000)
		            .sslEnabled(true)
		            .build();

		MongoClient client = new MongoClient(uri);
		MongoDatabase mdb = client.getDatabase("events-dev");
		MongoCollection<Document> mcoll = mdb.getCollection("events");
		
		System.out.println(uri.getUsername());
		System.out.println(mcoll.find());
		client.close();
		
	}
}
