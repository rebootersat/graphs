package findTwoDistinctNumberInArray;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DistinctNumbersFinderTest {

	private DistinctNumbersFinder finder;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		finder = new DistinctNumbersFinder();
	}

	@Test
	public void getDistinctNumbers_whenArrayLengthLessThanFour_shouldThrowException() {
		int arr[] = { 1, 2, 3 };
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid input length 3");
		finder.getDistinctNumbers(arr);
	}

	@Test
	public void getDistinctNumbers_shouldReturnDistinctNumbers() {
		int arr[] = { 2, 1, 3, 2 };
		int[] num= finder.getDistinctNumbers(arr);
		assertEquals(num[0], 1);
		assertEquals(num[1], 3);
	}

	@Test
	public void getRepeatedNumber_whenTwoConsecutiveNumbersAreRepeatedNumbers_shouldReturnTwo() {
		int arr[] = { 2, 1, 3, 2 };
		int repeatedNumber = finder.getRepeatedNumber(arr);
		assertEquals(repeatedNumber, 2);
	}

}
