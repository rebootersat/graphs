package machine.stats.core.utility;

import machine.stats.core.utility.CovarianceMatrix;

import org.junit.Test;

import addOn.ArithmeticOperationsInteger;

public class CovarianceMatrixTest
{
	@Test
	public void getCovarianceMatrix() {
		
		Integer[][] data = {
				{ 90,90,60,60,30 },
				{60,90,60,60,30},
				{90,30,60,90,30}
		};
		
		double[][] covarianceMatrix = CovarianceMatrix.getCovarianceMatrix(new ArithmeticOperationsInteger(), data);
		for (int i = 0; i < covarianceMatrix.length; i++)
		{
			for (int j = 0; j < covarianceMatrix.length; j++)
			{
				System.out.print(covarianceMatrix[i][j]+"  ,  ");
			}
			System.out.println();
		}
	}
	
}
