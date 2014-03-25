package uk.co.farhie.dynamictimewarping;

import uk.co.farhie.util.DistanceFunction;

public class DynamicTimeWarping {

	public static Double dynamicTimeWarping(int[] seriesOne, int[] seriesTwo, DistanceFunction chosenDistanceFunction) {
		Double cumulativeWarpPathDistance = 0.0;
		DistanceFunction distanceFunction = chosenDistanceFunction;
		int seriesOneLength = seriesOne.length;
		int seriesTwoLength = seriesTwo.length;
		
		double[][] localDistance = new double[seriesOneLength][seriesTwoLength];
		double[][] globalDistance = new double[seriesOneLength][seriesTwoLength];

		for (int i = 0; i < seriesOneLength; i++) {
			for (int j = 0; j < seriesTwoLength; j++) {
				localDistance[i][j] = distanceFunction.calculateDistance(seriesOne[i], seriesTwo[j]);
			}
		}
		globalDistance[0][0] = localDistance[0][0];

		for (int i = 1; i < seriesOneLength; i++) {
			globalDistance[i][0] = localDistance[i][0] + globalDistance[i - 1][0];
		}

		for (int i = 1; i < seriesOneLength; i++) {
			globalDistance[i][0] = localDistance[i][0] + globalDistance[i - 1][0];
		}

		for (int j = 1; j < seriesTwoLength; j++) {
			globalDistance[0][j] = localDistance[0][j] + globalDistance[0][j - 1];
		}

		for (int i = 1; i < seriesOneLength; i++) {
			for (int j = 1; j < seriesTwoLength; j++) {
				cumulativeWarpPathDistance = minimumValueFrom(globalDistance[i - 1][j], globalDistance[i - 1][j - 1], globalDistance[i][j - 1]);
				cumulativeWarpPathDistance = cumulativeWarpPathDistance + localDistance[i][j];
				globalDistance[i][j] = cumulativeWarpPathDistance;
			}
		}

		return globalDistance[seriesOneLength - 1][seriesTwoLength - 1];
	}

	private static double minimumValueFrom(double cellToTheLeft, double cellToLeftAndDown, double cellBelow) {
		return Math.min(Math.min(cellToTheLeft, cellToLeftAndDown), cellBelow);
	}
}