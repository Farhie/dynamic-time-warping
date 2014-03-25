package uk.co.farhie.util;

public class EuclideanDistance implements DistanceFunction {

	@Override
	public double calculateDistance(int[] vectorOne, int[] vectorTwo) {
		if (vectorOne.length != vectorTwo.length) {
			throw new IllegalArgumentException("Cannot calculate the distance between vectors of different sizes.");
		}

		double squareSum = 0.0;
		
		for (int i = 0; i < vectorOne.length; i++) {
			squareSum = squareSum + Math.pow(vectorOne[i] - vectorTwo[i], 2);
		}

		return Math.sqrt(squareSum);
	}

	@Override
	public double calculateDistance(int vectorOne, int vectorTwo) {
		int[] arrayVectorOne = {vectorOne};
		int[] arrayVectorTwo = {vectorTwo};
		return calculateDistance(arrayVectorOne, arrayVectorTwo);
	}

}
