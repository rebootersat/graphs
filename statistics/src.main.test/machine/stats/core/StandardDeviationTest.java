package machine.stats.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StandardDeviationTest
{
	private StandardDeviation sdev;

	@Before
	public void setUp() {
		sdev = new StandardDeviation();
	}
	
	@Test
	public void getStandDeviation() {
		double standDeviation = sdev.getStandDeviation(new double[]{0.0,8.0,12.0,20.0});
		System.out.println(" StandardDeviation  "+standDeviation);
		
		double standDeviation1 = sdev.getStandDeviation(new double[]{8.0,9.0,11.0,12.0});
		System.out.println(" StandardDeviation "+standDeviation1);
	}
}
