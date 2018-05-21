package machine.stats.core;

import addOn.ArithmeticOperations;

public class StandardDeviation<T extends Number>
{
	private T[] sampleData;
	private ArithmeticOperations<T> arithmeticOperations;
	
	public StandardDeviation(T[] sampleData, ArithmeticOperations<T> arithmeticOperations)
	{
		this.sampleData = sampleData;
		this.arithmeticOperations = arithmeticOperations;
	}
	
	public void setSampleData(T[] sampleData) {
		this.sampleData = sampleData;
	}
	public double getStandDeviation(T[] data) {
		double mean = new Mean<T>(data, arithmeticOperations).getMean();
		double squaredErrorSum = 0.0;
		for (int i = 0; i < data.length; i++)
			squaredErrorSum += (sampleData[i] - mean) * (sampleData[i] - mean);
		double squaredStandardDeviation = squaredErrorSum / (data.length - 1);
		return Math.sqrt(squaredStandardDeviation);
	}
}
