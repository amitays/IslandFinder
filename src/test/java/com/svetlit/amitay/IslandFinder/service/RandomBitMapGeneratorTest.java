package com.svetlit.amitay.IslandFinder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.svetlit.amitay.IslandFinder.model.BitMap;

public class RandomBitMapGeneratorTest {
	private RandomBitMapGenerator classUnderTest;
	
	private Random random = new Random(); 
	
	@BeforeEach
	private void setup() {
		classUnderTest = new RandomBitMapGenerator();
	}
	
	@Test
	void whenCreatingRandomMapThenContentChanges() {
		int size = random.nextInt(1000);
		assertThat(classUnderTest.generateMap(size, size))
		.isNotEqualTo(classUnderTest.generateMap(size, size));
	}
	
	@Test
	void whenCreatingRandomMapThenSizeMatchTheDesiredSize() {
		int width = random.nextInt(1000);
		int hight = random.nextInt(1000);
		
		assertThat(classUnderTest.generateMap(width, hight))
		.returns(width, BitMap::width)
		.returns(hight, BitMap::hight);
	}

}
