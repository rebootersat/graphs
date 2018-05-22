package machine.stats.core.utility;

import machine.stats.core.utility.Variance;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsDouble;

public class VarianceTest
{
	private Variance<Double> sdev;
	
	@Before
	public void setUp() {
		sdev = new Variance<Double>(new Double[]
		{ 0.0, 8.0, 12.0, 20.0 }, new ArithmeticOperationsDouble());
	}
	
	@Test
	public void getStandDeviation() {
		double standDeviation = sdev.getVariance();
		System.out.println(" StandardDeviation  " + standDeviation);
	}
	
}
