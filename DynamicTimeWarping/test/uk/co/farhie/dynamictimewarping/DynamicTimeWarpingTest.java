package uk.co.farhie.dynamictimewarping;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.farhie.util.EuclideanDistance;

public class DynamicTimeWarpingTest {

	private static final double ZERO_WARPING_DISTANCE = 0;
	private static final double DELTA = 10E-99;
	
	@Test
	public void warpingPathOfIdenticalSeries() {
		int[] timeSeries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
		Double warpingDistance = DynamicTimeWarping.dynamicTimeWarping(timeSeries, timeSeries, new EuclideanDistance());
		assertEquals(ZERO_WARPING_DISTANCE, warpingDistance, DELTA);
	}
	
	@Test
	public void warpingPathOfDifferentSeries() {
		int[] timeSeriesOne = {1, 1, 1, 2, 3, 2, 2};
		int[] timeSeriesTwo = {2, 1, 1, 1, 2, 3, 1};
		Double warpingDistance = DynamicTimeWarping.dynamicTimeWarping(timeSeriesOne, timeSeriesTwo, new EuclideanDistance());
		System.out.println(warpingDistance);
	}
}
