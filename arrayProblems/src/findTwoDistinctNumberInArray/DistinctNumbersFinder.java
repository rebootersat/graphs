package findTwoDistinctNumberInArray;

/**
 * 
 * There are 2*N+2 numbers where n numbers are repeated and two numbers are
 * distinct, find two distinct numbers.
 * 
 * @author SANDEEP
 *
 */
public class DistinctNumbersFinder {

	/**
	 * 
	 * Find the repeated number and perform XOR operation with numbers, if
	 * number is repeated then XOR result would be 0 otherwise non-zero.
	 * 
	 * @param arr
	 */
	public int[] getDistinctNumbers(int[] arr) {
		if (arr.length < 4)
			throw new IllegalArgumentException("Invalid input length " + arr.length);
		int index = 0;
		int[] res = new int[2];
		int repeatedNumber = getRepeatedNumber(arr);
		for (int i = 0; i < arr.length; i++) {
			if ((repeatedNumber ^ arr[i]) != 0) {
				res[index++] = arr[i];
				if (index == 2)
					break;
			}
		}
		return res;
	}

	/**
	 * Extract repeated number using brute force(implemented solution)
	 * 
	 * @param arr
	 *            input array
	 * @return repeated number
	 */
	public int getRepeatedNumber(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				result = arr[i] ^ arr[j];
				if (result == 0)
					return arr[i];
			}
		}
		return result;
	}

	/**
	 * Perform XOR for first two number, if result is non zero it means both
	 * numbers are distinct number or 1 distinct or one repeated. To make sure
	 * this perform XOR for at least next three numbers. if next three numbers
	 * are not available then check for three previous
	 * 
	 * Example 2,1,3,2
	 * 
	 * 2 is repeated number, if two consecutive numbers are different then next
	 * number would be a repeated number
	 * 
	 * Example 2,2,1,3
	 * 
	 */
	public int[] getDistinctNumbersUsingConsecutiveChecking(int[] arr) {
		int[] res = new int[2];
		int totalComparisions = 0;
		int j = 0;
		for (int i = 0; i < arr.length;) {
			// if two consecutive number are same skip both the numbers
			if ((arr[i] ^ arr[++j]) == 0) {
				// last two number are different
				if (i + 2 == arr.length) {
					res[0] = arr[i];
					res[1] = arr[i + 1];

					break;
				}
				i = i + 2;
				totalComparisions++;
				continue;
			} 
			// 
			else if (arr.length < i + 2) {
				totalComparisions++;
				i = i + 1;
			} else if ((arr[i] ^ arr[i + 3]) == 0) {
				totalComparisions++;
				i++;
			}
		}

		return null;
	}

}
