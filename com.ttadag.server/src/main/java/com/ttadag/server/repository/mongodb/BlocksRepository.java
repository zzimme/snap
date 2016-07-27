package com.ttadag.server.repository.mongodb;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ttadag.shared.model.Blocks;

public interface BlocksRepository extends MongoRepository<Blocks, ObjectId>{
	//public List<Blocks> findAll();
}
