package addOn;

public interface ArithmeticOperations<T>
{
	T zero();
	T add(T a, T b);
	double divide(T a, int b);
	T subtract(T a, T b);
	double subtract(T a, double b);
	T multiply(T a, T b);
}
