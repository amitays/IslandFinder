package com.svetlit.amitay.IslandFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svetlit.amitay.IslandFinder.model.BitMap;
import com.svetlit.amitay.IslandFinder.model.Island;
import com.svetlit.amitay.IslandFinder.service.IslandFinder;
import com.svetlit.amitay.IslandFinder.service.RandomBitMapGenerator;

@RestController
public class IslandFinderController {
	@Autowired
	IslandFinder islandFinder;

	@Autowired
	RandomBitMapGenerator randomBitMapGenerator;

	@Autowired
	ObjectMapper objectMapper;

	@PostMapping(value = "/islandfinder/randommap", produces = "application/json;charset=UTF-8")
	public @ResponseBody BitMap generateMap(@RequestParam(value = "width") int width,
			@RequestParam(value = "hight") int hight) {
		return randomBitMapGenerator.generateMap(width, hight);
	}

	@PostMapping(value = "/islandfinder/identify", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public List<Island> identifyIslands(@RequestBody BitMap map) throws JsonProcessingException {

		return islandFinder.findIslands(map);
	}

}
