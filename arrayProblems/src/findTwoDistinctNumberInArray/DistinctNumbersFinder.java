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
	 * There are two approaches for extracting repeated number 1. Perform XOR
	 * for first two number, if result is non zero it means both numbers are
	 * distinct number or 1 distinct or one repeated. To make sure this perform
	 * XOR for at least next three numbers.
	 * 
	 * Example 2,1,3,2
	 * 
	 * 2 is repeated number, if two consecutive numbers are different then next
	 * number would be a repeated number
	 * 
	 * Example 1,3,2,2 1 is not a repeated number so its XOR will never result
	 * in zero.After 3 Comparisons move on next number and repeat the same
	 * process.
	 * 
	 * 
	 * 2. Extract repeated number using brute force(implemented solution)
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

}
