package machine.stats.core;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import addOn.ArithmeticOperationsDouble;

public class MeanTest
{
	private Mean mean;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		mean = new Mean(new Double[]{0.0,8.0,12.0,20.0}, new ArithmeticOperationsDouble());
	}
	
	@Test
	public void getMean_forIntegerValues_shouldReturnTen() {
		double sampleMean = (double)mean.getMean();
		System.out.println(sampleMean);
		Assert.assertEquals(10.0, sampleMean);
	}
	
}
