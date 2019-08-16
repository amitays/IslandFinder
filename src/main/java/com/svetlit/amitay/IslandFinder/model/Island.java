package com.svetlit.amitay.IslandFinder.model;

import java.util.HashSet;
import java.util.Set;

public class Island {
	Set<Coordinate> coordinates = new HashSet<Coordinate>();
	
	public Set<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Set<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	public boolean addCoordinate(Coordinate coordinate) {
		return coordinates.add(coordinate);
	}
}
