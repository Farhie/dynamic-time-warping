package uk.co.farhie.dynamictimewarping;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.farhie.util.EuclideanDistance;

public class DynamicTimeWarpingTest {

	private static final double ZERO_WARPING_DISTANCE = 0;
	private static final double LARGE_WARPING_DISTANCE = 341.0;
	private static final double DELTA = 10E-99;
	
	@Test
	public void warpingPathOfIdenticalSeries() {
		int[] timeSeries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
		double warpingDistance = DynamicTimeWarping.dynamicTimeWarping(timeSeries, timeSeries, new EuclideanDistance());
		assertEquals(ZERO_WARPING_DISTANCE, warpingDistance, DELTA);
	}
	
	@Test
	public void warpingPathOfDifferentSeries() {
		int[] timeSeriesOne = {3, 4, 4, 4, 67};
		int[] timeSeriesTwo = {4, 5, 6, 8, 400};
		double warpingDistance = DynamicTimeWarping.dynamicTimeWarping(timeSeriesOne, timeSeriesTwo, new EuclideanDistance());
		assertEquals(LARGE_WARPING_DISTANCE, warpingDistance, DELTA);
		System.out.println(warpingDistance);
	}
}
