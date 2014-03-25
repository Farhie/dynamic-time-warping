package uk.co.farhie.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EuclideanDistanceTest {
	
	private static final double ONE_DIMENSION_DISTANCE = 14.0;
	private static final double MULTI_DIMENSIONAL_DISTANCE = 43.73785545725808;
	
	private static final double DELTA = 10E-99;
	
	private DistanceFunction euclideanDistance;
	
	@Before
	public void setup() {
		euclideanDistance = new EuclideanDistance();
	}
	
	@Test
	public void oneDimensionalEuclideanDistanceTest() {
		int[] vectorOne = {9};
		int[] vectorTwo = {23};
		double computedDistance = euclideanDistance.calculateDistance(vectorOne, vectorTwo);
		assertEquals(ONE_DIMENSION_DISTANCE, computedDistance, DELTA);
	}
	
	@Test
	public void multiDimensionalEuclideanDistanceTest() {
		int[] vectorOne = {9, 7, 6};
		int[] vectorTwo = {23, 1, 47};
		double computedDistance = euclideanDistance.calculateDistance(vectorOne, vectorTwo);
		assertEquals(MULTI_DIMENSIONAL_DISTANCE, computedDistance, DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownUponDifferentSizedInputs() {
		int[] vectorOne = {9,};
		int[] vectorTwo = {23, 1, 47};
		euclideanDistance.calculateDistance(vectorOne, vectorTwo);
	}
}
