package addOn;

public class ArithmeticOperationsInteger implements ArithmeticOperations<Integer>
{

	@Override
	public Integer zero() {
		return 0;
	}

	@Override
	public Integer add(Integer a, Integer b) {
		return a.intValue() + b.intValue();
	}

	@Override
	public double divide(Integer a, int b) {
		return a.intValue() / b;
	}
	
}
