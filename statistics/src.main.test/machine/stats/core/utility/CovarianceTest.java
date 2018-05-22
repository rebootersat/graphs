package machine.stats.core.utility;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsDouble;

public class CovarianceTest
{
	private Covariance<Double> covariance;
	
	@Before
	public void setUp() {
		covariance = new Covariance<Double>(new Double[]
		{ 2.1, 2.5, 4.0, 3.6 }, new Double[]
		{ 8.0, 12.0, 14.0, 10.0 }, new ArithmeticOperationsDouble());
	}
	
	@Test
	public void getStandDeviation() {
		double covr = covariance.getCovariance();
		// for above problem it should be 1.53
		System.out.println(" Covariance  " + covr);
		
	}
}
