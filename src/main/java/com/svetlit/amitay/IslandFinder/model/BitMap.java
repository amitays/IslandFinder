package com.svetlit.amitay.IslandFinder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMap {
	private final boolean[][] map;
	
	public BitMap(@JsonProperty("map") boolean[][] map) {
		validate(map);
		this.map = map;
	}
	
	private void validate(boolean[][] map) {
		//TODO: Normally i would validate that the map is valid (not empty, initialized as a square e.t.c) and throw an exception if not valid
	}
	
	public boolean[][] getMap() {
		return map.clone();
	}

	public int width() {
		return map.length;
	}

	public int hight() {
		return map[0].length;
	}

	public boolean isLand(Coordinate coordinate) {
		//TODO: validate longitude and latitude in bound
		return map[coordinate.getLongitude()][coordinate.getLatitude()];
	}
}
