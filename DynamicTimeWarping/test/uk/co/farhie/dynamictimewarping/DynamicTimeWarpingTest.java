package uk.co.farhie.dynamictimewarping;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicTimeWarpingTest {

	private static final int ZERO_WARPING_DISTANCE = 0;
	
	@Test
	public void warpingPathOfIdenticalSeries() {
		int[] timeSeries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
		int warpingDistance = DynamicTimeWarping.dynamicTimeWarping(timeSeries, timeSeries);
		assertEquals(ZERO_WARPING_DISTANCE, warpingDistance);
	}
}
