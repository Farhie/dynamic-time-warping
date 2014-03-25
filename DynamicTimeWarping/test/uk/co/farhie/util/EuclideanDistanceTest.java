package uk.co.farhie.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EuclideanDistanceTest {
	
	private static final int ONE_DIMENSION_DISTANCE = 14;
	
	private DistanceFunction euclideanDistance;
	
	@Before
	public void setup() {
		euclideanDistance = new EuclideanDistance();
	}
	
	@Test
	public void oneDimensionalEuclideanDistanceTest() {
		int[] vectorOne = {9};
		int[] vectorTwo = {23};
		int computedDistance = euclideanDistance.calculateDistance(vectorOne, vectorTwo);
		assertEquals(ONE_DIMENSION_DISTANCE, computedDistance);
	}
	
}
