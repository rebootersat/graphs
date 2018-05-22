package machine.stats.core;

import addOn.ArithmeticOperations;

public class Variance<T extends Number>
{
	private T[] sampleData;
	private ArithmeticOperations<T> arithmeticOperations;
	
	public Variance(T[] sampleData, ArithmeticOperations<T> arithmeticOperations)
	{
		this.sampleData = sampleData;
		this.arithmeticOperations = arithmeticOperations;
	}
	
	public void setSampleData(T[] sampleData) {
		this.sampleData = sampleData;
	}
	
	public double getVariance() {
		double mean =new Mean<T>(sampleData, arithmeticOperations).getMean();
		double squaredErrorSum = 0.0;
		for (int i = 0; i < sampleData.length; i++)
			squaredErrorSum += (arithmeticOperations.subtract(sampleData[i], mean) * arithmeticOperations.subtract(sampleData[i], mean));
		double variance = squaredErrorSum / (sampleData.length - 1);
		return variance;
	}
	
	public static <T extends Number> double getVariance(T[] sampleData, ArithmeticOperations<T> arithmeticOperations) {
		double mean =new Mean<T>(sampleData, arithmeticOperations).getMean();
		double squaredErrorSum = 0.0;
		for (int i = 0; i < sampleData.length; i++)
			squaredErrorSum += (arithmeticOperations.subtract(sampleData[i], mean) * arithmeticOperations.subtract(sampleData[i], mean));
		double variance = squaredErrorSum / (sampleData.length - 1);
		return variance;
	}
}

