package machine.stats.core.utility;

import machine.stats.core.utility.StandardDeviation;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsDouble;

public class StandardDeviationTest
{
	private StandardDeviation<Double> sdev;
	
	@Before
	public void setUp() {
		sdev = new StandardDeviation<Double>(new Double[]
		{ 0.0, 8.0, 12.0, 20.0 }, new ArithmeticOperationsDouble());
	}
	
	@Test
	public void getStandDeviation() {
		double standDeviation = sdev.getStandDeviation();
		System.out.println(" StandardDeviation  " + standDeviation);
	}
}
