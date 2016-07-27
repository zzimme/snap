package com.ttadag.server.mongodb.converter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.ttadag.shared.model.Blocks;

public class BlockReadConverter implements Converter<DBObject,Blocks>{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Blocks convert(DBObject source) {
		// TODO Auto-generated method stub
		Set<String> keys = source.keySet();
		Iterator<String> ikeys = keys.iterator();
		
		Blocks block = new Blocks();
		ObjectMapper om = new ObjectMapper();
		logger.info("kyes:{}, source:{}",keys.toString(), source.toString());
		while (ikeys.hasNext()) {
			String ckey = ikeys.next();
			if ("_id".equals(ckey) == false) {
				logger.info("ckey:{}, source:{}",ckey,source.get(ckey).toString());
				try {
					block = om.readValue(source.get(ckey).toString(), Blocks.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//block = (Blocks) source.get(ckey);
				block.setKey(ckey);
				
				/*
				block.setCategory((String) source.get("category"));
				block.setOnly((String) source.get("only"));
				block.setSpec((String) source.get("spec"));
				block.setDefaults( (Object[]) source.get("defaults"));
				block.setType((String) source.get("type"));
				;
				*/
			}
			logger.info(ckey);
		}
		//logger.info(source.toString());
		
		return block;
	}

}
