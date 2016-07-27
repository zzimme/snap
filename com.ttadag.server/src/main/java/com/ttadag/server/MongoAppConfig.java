package com.ttadag.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.ttadag.server.mongodb.converter.BlockReadConverter;

//@Configuration
public class MongoAppConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;
	
	@Value("${spring.data.mongodb.port}")
	private String mongoPort;
	
	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient(this.mongoHost+":"+this.mongoPort);
	}

	@Override
	public String getDatabaseName() {
		return this.database;
	}

	// the following are optional

	@Bean
	@Override
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
		converterList.add(new BlockReadConverter());
		return new CustomConversions(converterList);
	}

}
