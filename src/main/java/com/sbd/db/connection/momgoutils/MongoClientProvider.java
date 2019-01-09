package com.sbd.db.connection.momgoutils;

import com.mongodb.MongoClient;
import com.sbd.db.connection.ResourceBundleHandler;
import com.sbd.db.utils.Utils;

public class MongoClientProvider 
{	
	private MongoClientProvider() {};
	
	private static MongoClient mongoClient;
	
	public static MongoClient getInstance()
	{
		if(mongoClient != null)
			return mongoClient;
		
		getMongoClientConnection();
		
		return mongoClient;
	}


	private static synchronized void getMongoClientConnection()
	{
		if(mongoClient != null)
			return;
		
		try 
		{
			String connectionURI = "mongodb+srv://{3}:{4}@{1}/{2}?retryWrites=true";
			String host = ResourceBundleHandler.getString("DBHOST");
			host = Utils.getDecryptedPassword(host);
			String db = ResourceBundleHandler.getString("DBNAME");
			String user = ResourceBundleHandler.getString("DBUSER");
			String password = ResourceBundleHandler.getString("DBPASSWORD");		
			password = Utils.getDecryptedPassword(password);
			
			connectionURI = Utils.formatMessage(connectionURI, host, db, user, password);
			
			mongoClient = new MongoClient(connectionURI);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
