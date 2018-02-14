package sequenceIncreasingOrder;

public class SubSequenceFinder {

	private int arr[];

	public SubSequenceFinder(int[] arr) {
		this.arr = arr;
	}
	
	public boolean hasSequence(int seqLength) {
		int count = 1;
		boolean hasSequence = false;
		for (int i = 1; i < arr.length; i++) {

			if(arr[i] > arr[i-1])
				count++;
			else
				count = 1;
			if (count >= seqLength) {
				hasSequence = true;
				showSequence(i, seqLength);
			}
		}
		return hasSequence;
	}

	private void showSequence(int lastIndex, int seqLength) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = lastIndex - seqLength + 1; i <= lastIndex; i++) {
			builder.append(arr[i]);
			if (i != lastIndex)
				builder.append(",");
		}
		builder.append("]");
		System.out.println(builder);
	}
}
