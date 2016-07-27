package com.ttadag.server.repository.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ttadag.shared.model.Block;


public interface BlockRepository extends MongoRepository<Block, ObjectId>{

}
