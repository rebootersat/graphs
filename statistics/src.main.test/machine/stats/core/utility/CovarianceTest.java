package machine.stats.core;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsDouble;

public class CovarianceTest
{
	private Covariance<Double> sdev;
	
	@Before
	public void setUp() {
		sdev = new Covariance<Double>(new Double[]
		{ 0.0, 8.0, 12.0, 20.0 }, new Double[]
		{ 0.0, 32.0, 12.0, 30.0 }, new ArithmeticOperationsDouble());
	}
	
	@Test
	public void getStandDeviation() {
		double standDeviation = sdev.getCovariance();
		System.out.println(" StandardDeviation  " + standDeviation);
	}
}
