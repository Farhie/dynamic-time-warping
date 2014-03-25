package uk.co.farhie.util;

public interface DistanceFunction {
	
	public double calculateDistance(int[] vectorOne, int[] vectorTwo);
	
	public double calculateDistance(int vectorOne, int vectorTwo);
   
}
