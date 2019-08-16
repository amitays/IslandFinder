package com.svetlit.amitay.IslandFinder.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
	
	private Random random = new Random(); 
	
	@Test
	void whenGettingNeighboursThenConsiderMapSize() {
		//Randomize map size, make sure the minimum size is 3X3
		int width = random.nextInt(1000)+3;
		int hight = random.nextInt(1000)+3;
		
		//check corners
		assertThat(new Coordinate(0, 0).getNeighbours(width, hight)).hasSize(3);
		assertThat(new Coordinate(width-1, 0).getNeighbours(width, hight)).hasSize(3);
		assertThat(new Coordinate(0, hight-1).getNeighbours(width, hight)).hasSize(3);
		assertThat(new Coordinate(width-1, hight-1).getNeighbours(width, hight)).hasSize(3);
		
		//check borders
		assertThat(new Coordinate(width/2, 0).getNeighbours(width, hight)).hasSize(5);
		assertThat(new Coordinate(width-1, hight/2).getNeighbours(width, hight)).hasSize(5);
		assertThat(new Coordinate(width/2, hight-1).getNeighbours(width, hight)).hasSize(5);
		assertThat(new Coordinate(0, hight/2).getNeighbours(width, hight)).hasSize(5);
		
		//check middle map
		assertThat(new Coordinate(width/2, hight/2).getNeighbours(width, hight)).hasSize(8);
		
	}
}
