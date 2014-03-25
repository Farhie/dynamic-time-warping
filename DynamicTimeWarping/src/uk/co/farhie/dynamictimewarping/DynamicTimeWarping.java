package uk.co.farhie.dynamictimewarping;

import uk.co.farhie.util.DistanceFunction;

public class DynamicTimeWarping {
	
	public static Double dynamicTimeWarping(int[] seriesOne, int[] seriesTwo, DistanceFunction chosenDistanceFunction) {
		Double cumulativeWarpPathCost;
		DistanceFunction distanceFunction = chosenDistanceFunction;
		double[][] dynamicTimeWarping = new double[seriesOne.length][seriesTwo.length];
		
		initialiseDynamicTimeWarpingMatrix(seriesOne, seriesTwo, dynamicTimeWarping);
		
		for(int i = 1; i < seriesOne.length; i++){
			for(int j = 1; j < seriesTwo.length; j++){
				cumulativeWarpPathCost = distanceFunction.calculateDistance(seriesOne[i], seriesTwo[j]);
				dynamicTimeWarping[i][j] = cumulativeWarpPathCost + minimumValue(dynamicTimeWarping, i, j);
			}
		}
		
		
		
		return dynamicTimeWarping[seriesOne.length - 1][seriesTwo.length - 1];
	}

	private static void initialiseDynamicTimeWarpingMatrix(int[] seriesOne, int[] seriesTwo, double[][] dynamicTimeWarping) {
		for(int i = 0; i < seriesOne.length; i++){
			dynamicTimeWarping[i][0] = Double.POSITIVE_INFINITY;
		}
		
		for(int i = 0; i < seriesTwo.length; i++){
			dynamicTimeWarping[0][i] = Double.POSITIVE_INFINITY;
		}
		
		dynamicTimeWarping[0][0] = 0.0;
	}

	private static Double minimumValue(double[][] dynamicTimeWarping, int i, int j) {
		double leftCell = getValueInCellToTheLeft(dynamicTimeWarping, i, j);
		double diagonalCell = getValueInCellDiagonal(dynamicTimeWarping, i, j);
		double belowCell = getValueInCellBelow(dynamicTimeWarping, i, j);
		
		return smallestOfThreeValues(leftCell, diagonalCell, belowCell);
	}

	private static double getValueInCellToTheLeft(double[][] dynamicTimeWarping, int i, int j) {
		if(i != 0) {
			return dynamicTimeWarping[i-1][j];
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}

	private static double getValueInCellDiagonal(double[][] dynamicTimeWarping, int i, int j) {
		if(j!= 0) {			
			return dynamicTimeWarping[i][j-1];
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	private static double getValueInCellBelow(double[][] dynamicTimeWarping, int i, int j) {
		if(i != 0 && j != 0){
			return dynamicTimeWarping[i-1][j-1];
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	private static Double smallestOfThreeValues(double leftCell, double diagonalCell, double belowCell) {
		if(leftCell < diagonalCell && leftCell < belowCell) {
			return leftCell;
		}
		
		if(diagonalCell < leftCell && diagonalCell < belowCell) {
			return diagonalCell;
		}
		
		if(belowCell < leftCell && belowCell < diagonalCell) {
			return belowCell;
		}
		return belowCell;
	}
}