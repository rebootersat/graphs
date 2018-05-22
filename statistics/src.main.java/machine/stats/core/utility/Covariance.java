package machine.stats.core.utility;

import addOn.ArithmeticOperations;

public class Covariance<T extends Number>
{
	private T[] x1;
	private T[] x2;
	private ArithmeticOperations<T> artmtOpr;
	
	public Covariance(T[] x1, T[] x2, ArithmeticOperations<T> arithmeticOperations)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.artmtOpr = arithmeticOperations;
	}
	
	public void setX1(T[] x1) {
		this.x1 = x1;
	}
	
	public void setX2(T[] x2) {
		this.x2 = x2;
	}
	
	public double getCovariance() {
		if (x1.length != x2.length)
			throw new IllegalArgumentException("Sample size not same, X1 = " + x1.length + " X2= " + x2.length);
		double x1Mean =new Mean<T>(x1, artmtOpr).getMean();
		double x2Mean =new Mean<T>(x2, artmtOpr).getMean();
		System.out.println("X1 mean "+x1Mean);
		System.out.println("X2 mean "+x2Mean);
		double sum = 0.0;
		for (int i = 0; i < x1.length; i++){
			double first = artmtOpr.subtract(x1[i], x1Mean);
			double second = artmtOpr.subtract(x2[i], x2Mean);
			sum = sum + (first * second);
			System.out.println(first+" , "+second+" = "+first * second+" SUM "+sum);
		}
		System.out.println(sum);
		return sum/ (x1.length - 1);
	}
	
	public static <T extends Number> double getCovariance(T[] x1, T[] x2, ArithmeticOperations<T> artmtOpr) {
		if (x1.length != x2.length)
			throw new IllegalArgumentException("Sample size not same, X1 = " + x1.length + " X2= " + x2.length);
		double x1Mean =new Mean<T>(x1, artmtOpr).getMean();
		double x2Mean =new Mean<T>(x2, artmtOpr).getMean();
		double sum = 0.0;
		for (int i = 0; i < x1.length; i++)
			sum = sum + (artmtOpr.subtract(x1[i], x1Mean) * artmtOpr.subtract(x2[i], x2Mean));
		return sum/ (x1.length - 1);
	}
}
