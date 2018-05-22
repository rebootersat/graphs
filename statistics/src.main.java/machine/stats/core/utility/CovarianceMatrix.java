package machine.stats.core.utility;

import addOn.ArithmeticOperations;

public class CovarianceMatrix<T extends Number>
{
	public static <T extends Number> double[][] getCovarianceMatrix(ArithmeticOperations<T> artmtOpr, T[][] data) {
		double[][] covMatrix = new double[data.length][data.length];
		for (int i = 0; i < covMatrix.length; i++)
			for (int j = 0; j < covMatrix[i].length; j++)
				covMatrix[i][j] = Covariance.getCovariance(data[i], data[j], artmtOpr);
		return covMatrix;
	}
}
