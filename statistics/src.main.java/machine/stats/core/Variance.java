package machine.stats.core;

public class Variance
{
	public static double getVariance(double[] data) {
		double mean = Mean.getMean(data);
		double squaredErrorSum = 0.0;
		for (int i = 0; i < data.length; i++)
			squaredErrorSum += (data[i] - mean) * (data[i] - mean);
		double variance = squaredErrorSum / (data.length - 1);
		return variance;
	}
}

