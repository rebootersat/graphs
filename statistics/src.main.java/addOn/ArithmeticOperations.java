package addOn;

public interface ArithmeticOperations<T>
{
	T zero();
	T add(T a, T b);
	double divide(T a, int b);
}
