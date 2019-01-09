package com.sbd.db.utils;

import java.util.Map;

public class CollectionMapper 
{
	private static Map<String, String> collectionInformation = null;
	
	public static String getCollection(Class<?> clazz)
	{
		if(collectionInformation == null || collectionInformation.isEmpty())
		{
			loadCollectionResourceBundle();
		}
		return collectionInformation.get(clazz.getName());		
	}

	private synchronized static void loadCollectionResourceBundle()
	{
		if(collectionInformation != null && !collectionInformation.isEmpty())
		{
			return;
		}	
		collectionInformation = Utils.getMapFromRB("collectionmapper");
	}
	
	
}
