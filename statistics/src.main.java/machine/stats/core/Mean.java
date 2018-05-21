package machine.stats.core;

import addOn.ArithmeticOperations;

public class Mean<T extends Number>
{
	private T[] sampleData;
	private ArithmeticOperations<T> arithmeticOperations;
	
	public Mean(T[] sampleData, ArithmeticOperations<T> arithmeticOperations)
	{
		this.sampleData = sampleData;
		this.arithmeticOperations = arithmeticOperations;
	}
	
	public void setSampleData(T[] sampleData) {
		this.sampleData = sampleData;
	}
	
	public double getMean(){
		if (sampleData == null)
			throw new NullPointerException("No data provided");
		if (sampleData.length == 0)
			throw new IllegalArgumentException("Empty data set not allowed");
		
		T sum = arithmeticOperations.zero();
		for (int i = 0; i < sampleData.length; i++)
			sum = arithmeticOperations.add(sum, sampleData[i]);
		
		return arithmeticOperations.divide(sum , sampleData.length);
	}
}
