package com.svetlit.amitay.IslandFinder.model;

import java.util.HashSet;
import java.util.Set;

public class Coordinate {
	private final int longitude;
	private final int latitude;
	
	public Coordinate(int longitude, int latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	@Override
	public String toString() {
		return "[" + longitude + "," + latitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + longitude;
		result = prime * result + latitude;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (longitude != other.longitude)
			return false;
		if (latitude != other.latitude)
			return false;
		return true;
	}
	
	public Set<Coordinate> getNeighbours(int width, int hight) {
		Set<Coordinate> result = new HashSet<Coordinate>(8);
		// top row
		result.add(new Coordinate(Math.max(longitude - 1, 0), Math.max(latitude - 1, 0)));
		result.add(new Coordinate(longitude, Math.max(latitude - 1, 0)));
		result.add(new Coordinate(Math.min(longitude + 1, width - 1),
				Math.max(latitude - 1, 0)));

		// middle row
		result.add(new Coordinate(Math.max(longitude - 1, 0), latitude));
		result.add(new Coordinate(Math.min(longitude + 1, width - 1), latitude));

		// lower row
		result.add(new Coordinate(Math.max(longitude - 1, 0),
				Math.min(latitude + 1, hight - 1)));
		result.add(new Coordinate(longitude, Math.min(latitude + 1, hight - 1)));
		result.add(new Coordinate(Math.min(longitude + 1, width - 1),
				Math.min(latitude + 1, hight - 1)));
		
		//remove current coordinates that could have been added
		result.remove(this);
		
		return result;
	}
}
