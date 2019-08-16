package com.svetlit.amitay.IslandFinder.service;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.svetlit.amitay.IslandFinder.model.BitMap;

@Component
public class RandomBitMapGenerator {
	Random random = new Random();
	
	public BitMap generateMap(int width, int hight) {
		boolean[][] map = new boolean[width][hight];
		IntStream.range(0, width).forEach(
				x -> IntStream.range(0, hight).forEach(
						y -> map[x][y] = random.nextBoolean()));
		
		return new BitMap(map);
	}
	 
}
