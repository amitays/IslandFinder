package com.svetlit.amitay.IslandFinder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.svetlit.amitay.IslandFinder.model.BitMap;

public class IslandFinderTest {
	private IslandFinder classUnderTest;
	
	@BeforeEach
	private void setup() {
		classUnderTest = new IslandFinder();
	}
	
	@ParameterizedTest
	@MethodSource("knownIslandPatterns")
	void whenFindIslandsThenFindTheExpectedNumber(int numOfIslands, BitMap bitMap) {
	    assertThat(classUnderTest.findIslands(bitMap)).hasSize(numOfIslands);
	}
	
	private static Stream<Arguments> knownIslandPatterns() {
	    return Stream.of(
	    		Arguments.of(0, new BitMap(new boolean[][]{
	    			{false},
					{false}})),
	    		Arguments.of(1, new BitMap(new boolean[][]{
	    			{true},
	    			{true}})),
	    		Arguments.of(2, new BitMap(new boolean[][]{
	    			{false, false, false, false, false, false},
	    			{false, true, true, true, true, true},
	    			{false, true, false, false, false, true},
	    			{false, true, false, true, false, true},
	    			{false, true, false, false, false, true},
	    			{false, true, true, true, true, true}})),
	    		Arguments.of(3, new BitMap(new boolean[][]{
	    			{true, false, true, false, true, false},
	    			{true, false, true, false, true, false},
	    			{true, false, true, false, true, false},
	    			{true, false, true, false, true, false},
	    			{true, false, true, false, true, false}})),
	    		Arguments.of(2, new BitMap(new boolean[][]{
	    			{true, false, false, false, false, false},
	    			{false, true, false, false, false, false},
	    			{false, false, true, false, false, false},
	    			{false, false, false, false, false, false},
	    			{false, false, false, false, true, false},
	    			{false, false, false, false, false, true}}))
	    );
	}
}
