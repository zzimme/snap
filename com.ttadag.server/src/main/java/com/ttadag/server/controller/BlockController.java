package com.ttadag.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttadag.server.service.BlockService;
import com.ttadag.shared.model.Block;
import com.ttadag.shared.model.Blocks;

@RestController
@RequestMapping(value = { "/block" })
public class BlockController {

	@Autowired
	private BlockService blockService;
	
	@RequestMapping(value = { "/get/init" })
	public List<Blocks> getBlockList(){
		List<Blocks> list = blockService.getBlockList();
		
		for (int i = 0; i < list.size(); i++) {
			Blocks blocks = list.get(i);
			
			Block block = new Block();
			block.setCategory(blocks.getCategory());
			block.setType(blocks.getType());
			block.setKey(blocks.getKey());
			block.setDefaults(blocks.getDefaults());
			block.setOnly(blocks.getOnly());
			block.setSpec(blocks.getSpec());
			block.setDev(blocks.getDev());
			blockService.setBlock(block);
		}
		return list;
	}
}
