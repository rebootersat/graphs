package addOn;

public class ArithmeticOperationsDouble implements ArithmeticOperations<Double>
{

	@Override
	public Double zero() {
		return 0.0;
	}

	@Override
	public Double add(Double a, Double b) {
		return a.doubleValue() + b.doubleValue();
	}

	@Override
	public double divide(Double a, int b) {
		return a.doubleValue() / b;
	}
	
	@Override
	public Double subtract(Double a, Double b) {
		return a.doubleValue() - b.doubleValue();
	}

	@Override
	public double subtract(Double a, double b) {
		return a.doubleValue() - b;
	}

	@Override
	public Double multiply(Double a, Double b) {
		return a.doubleValue() * b.doubleValue();
	}
}
