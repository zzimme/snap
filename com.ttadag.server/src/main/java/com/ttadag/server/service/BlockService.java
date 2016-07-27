package com.ttadag.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttadag.server.repository.mongodb.BlockRepository;
import com.ttadag.server.repository.mongodb.BlocksRepository;
import com.ttadag.shared.model.Block;
import com.ttadag.shared.model.Blocks;

@Service
public class BlockService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BlocksRepository blocksRepository;
	
	@Autowired
	private BlockRepository blockRepository;
	
	public List<Blocks> getBlockList(){
	
		List<Blocks> result = blocksRepository.findAll();
		return result;
	}
	
	public void setBlock(Block block){
		blockRepository.save(block);
	}
}
