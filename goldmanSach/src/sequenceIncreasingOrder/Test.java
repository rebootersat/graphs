package sequenceIncreasingOrder;

public class Test {

	public static void main(String[] args) {
		int arr[] = { -11, -10, -9, 8, -7, -6, -5, -4, -3, -2, -1 };
		SubSequenceFinder seqFinder = new SubSequenceFinder(arr);
		boolean hasSeq = seqFinder.hasSequence(3);
		if (hasSeq)
			System.out.println("Increasing Sequence for length " + 3
					+ " exists");
		else
			System.out.println("Increasing Sequence for length " + 3
					+ " does not exist");

	}

}
