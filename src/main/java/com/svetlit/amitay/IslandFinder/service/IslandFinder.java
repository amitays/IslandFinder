package com.svetlit.amitay.IslandFinder.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.svetlit.amitay.IslandFinder.model.BitMap;
import com.svetlit.amitay.IslandFinder.model.Coordinate;
import com.svetlit.amitay.IslandFinder.model.Island;

@Service
public class IslandFinder {

	public List<Island> findIslands(BitMap map) {
		List<Island> islands = new LinkedList<Island>();
		Set<Coordinate> foundCoordinates = new HashSet<Coordinate>();

		// iterate over all map coordinates
		for (int x = 0; x < map.width(); x++) {
			for (int y = 0; y < map.hight(); y++) {
				Coordinate position = new Coordinate(x, y);
				// hit uncharted land, create a new island
				if (map.isLand(position) && !foundCoordinates.contains(position)) {
					Island island = new Island();
					islands.add(island);
					discoverIsland(map, island, foundCoordinates, position);
				}
			}
		}

		return islands;
	}

	private void discoverIsland(BitMap map, Island island, Set<Coordinate> foundCoordinates, Coordinate position) {
		foundCoordinates.add(position);
		island.addCoordinate(position);

		// discover all neighbor coordinates that marked as land, recurse on the new coordinates 
		position.getNeighbours(map.width(), map.hight()).stream()
			.filter(map::isLand)
			.filter(coordinate -> !foundCoordinates.contains(coordinate))
			.forEach(coordinate -> discoverIsland(map, island, foundCoordinates, coordinate));
	}

	
}
