package maxDiffBetweenIndexes;

/**
 * Problem : find max value for j-i where arr[j]>arr[i]
 * 
 * @author SANDEEP
 *
 */
public class MaxDiffForTwoIndex {

	/**
	 * Brute force checking Pick first(i=0) and last(j=n-1) elements, compare ,
	 * if condition not satisfied then decrease the last index and keep doing
	 * this until i>j
	 * 
	 * now increase the value of i by one and repeat the same process. store max
	 * difference and update if new difference is grater than previous
	 * difference
	 * 
	 * @param arr
	 *            elements
	 * @return max difference
	 */
	public int findDifference(int[] arr) {
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] > arr[i] && maxDiff < (j - i))
					maxDiff = j - i;
			}
		}
		return maxDiff;
	}

}
