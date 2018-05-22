package machine.stats.core.utility;

import machine.stats.core.utility.Covariance;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsInteger;

public class CovarianceTest
{
	private Covariance<Integer> covariance;
	
	@Before
	public void setUp() {
		covariance = new Covariance<Integer>(new Integer[]
		{ 9, 15, 25, 14, 10, 18, 0, 16, 5, 19, 16, 20 }, new Integer[]
		{ 39, 56, 93, 61, 50, 75, 32, 85, 42, 70, 66, 80 }, new ArithmeticOperationsInteger());
	}
	
	@Test
	public void getStandDeviation() {
		double covr = covariance.getCovariance();
		System.out.println(" Covariance  " + covr);
	}
}
