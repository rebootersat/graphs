package machine.stats.core.utility;

import machine.stats.core.utility.CovarianceMatrix;

import org.junit.Test;

import addOn.ArithmeticOperationsInteger;

public class CovarianceMatrixTest
{
	@Test
	public void getCovarianceMatrix() {
		
		Integer[][] data = {
				{ 9, 15, 25, 14, 10, 18, 0, 16, 5, 19, 16, 20 },
				{ 39, 56, 93, 61, 50, 75, 32, 85, 42, 70, 66, 80 }
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
