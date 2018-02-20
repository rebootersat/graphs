package maxDiffBetweenIndexes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxDiffForTwoIndexTest {

	private MaxDiffForTwoIndex diff;

	@Before
	public void setUp() {
		
		diff = new MaxDiffForTwoIndex();
	}
	
	@Test
	public void findDifference_whenAarraylengthLessThanTwo_shouldReturnZero() {
		int arr[] = {1};
		int maxDiff= diff.findDifference(arr);
		assertEquals(maxDiff, 0);
	}
	
	@Test
	public void findDifference_whenArrayElementsAreInDescendingorder_shouldReturnZero() {
		int arr[] = {9,8,7,5,4,3,2,1};
		int maxDiff= diff.findDifference(arr);
		assertEquals(maxDiff, 0);
	}
	
	@Test
	public void findDifference_whenFirstElementIsLessThanLastElement_shouldReturnEight() {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int maxDiff= diff.findDifference(arr);
		assertEquals(maxDiff, 8);
	}
	
}
