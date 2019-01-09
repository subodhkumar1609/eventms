/*package com.sbd.db.connection;

import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.Codec;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

public class MongoPojo
{
	// Create a CodecRegistry containing the PojoCodecProvider instance.
	CodecProvider pojoCodecProvider = PojoCodecProvider.builder().register("com.sbd.db.entity").build();
	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
	
	*//**
	 * "Smart" registry just for this particular {@code type}. It is typically composed with existing
	 * registries using {@link org.bson.codecs.configuration.CodecRegistries#fromRegistries(CodecRegistry...)} method.
	 *//*
	public static <T> CodecRegistry registryFor(final Class<T> type, final TypeAdapter<T> adapter) {
	  return new CodecRegistry() {
	    @SuppressWarnings("unchecked")
	    @Override
	    public <X> Codec<X> get(Class<X> clazz) {
	      // TODO is this a safe assumption with polymorphism (in repositories) ?
	      if (type.isAssignableFrom(clazz)) {
	        return (Codec<X>) codecFor(type, adapter);
	      } else {
	        // let other registries decide
	        throw new CodecConfigurationException(String.format("Type %s not supported by this registry", type.getName()));
	      }
	    }
	  };
	}
	 
}
*/