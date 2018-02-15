package subMatrixWithZeroSum;

import java.util.HashMap;
import java.util.Map;

public class SubMatrix {
	private int[][] arr;
	private int[][] firstAndLastIndexInfoInRow;
	private int[][] firstAndLastIndexInfoInColumn;
	private int row;
	private int column;

	public SubMatrix(int[][] arr) {
		this.arr = arr;
		this.row = arr.length;
		this.column = arr[0].length;
		firstAndLastIndexInfoInRow = new int[row][2];
		firstAndLastIndexInfoInColumn = new int[column][2];
	}

	public void initFirstAndLastIndexForZeroSumInEachRow() {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 0; i < row; i++) {
			long sum = 0;
			map.clear();
			for (int j = 0; j < column; j++) {
				sum += arr[i][j];
				if (map.containsKey(sum)) {
					Integer firstIndex = map.get(sum) + 1;
					if (j - firstIndex > firstAndLastIndexInfoInRow[i][1]
							- firstAndLastIndexInfoInRow[i][0]) {
						firstAndLastIndexInfoInRow[i][0] = firstIndex;
						firstAndLastIndexInfoInRow[i][1] = j;
					}
				} else
					map.put(sum, j);
			}
		}
	}

	public void initFirstAndLastIndexForZeroSumInEachColumn() {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 0; i < column; i++) {
			long sum = 0;
			map.clear();
			for (int j = 0; j < row; j++) {
				sum += arr[j][i];
				if (map.containsKey(sum)) {
					Integer firstIndex = map.get(sum) + 1;
					if (j - firstIndex > firstAndLastIndexInfoInColumn[i][1]
							- firstAndLastIndexInfoInColumn[i][0]) {
						firstAndLastIndexInfoInColumn[i][0] = firstIndex;
						firstAndLastIndexInfoInColumn[i][1] = j;
					}
				} else
					map.put(sum, j);
			}
		}
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < firstAndLastIndexInfoInRow.length; i++) {
			for (int j = 0; j < firstAndLastIndexInfoInRow[i].length; j++) {
				builder.append(firstAndLastIndexInfoInRow[i][j]).append(" ");
			}
			builder.trimToSize();
			builder.append("\n");
		}

		builder.append("Column wise");
		builder.append("\n");

		for (int i = 0; i < firstAndLastIndexInfoInColumn.length; i++) {
			for (int j = 0; j < firstAndLastIndexInfoInColumn[i].length; j++) {
				builder.append(firstAndLastIndexInfoInColumn[i][j]).append(" ");
			}
			builder.trimToSize();
			builder.append("\n");
		}
		return builder.toString();
	}

	public void subMatrixRowWise() {
		int minCol = 0;
		int maxCol = 0;
		int consecutiveRowCount = 0;
		;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < firstAndLastIndexInfoInRow.length; i++) {
			// firstAndLastIndexInfoInRow[i][0];
			// firstAndLastIndexInfoInRow[i][0];
		}
	}

	public void subMatrixColumnWise() {
		int minRow = firstAndLastIndexInfoInColumn[0][0];
		int maxRow = firstAndLastIndexInfoInColumn[0][1];
		int firstColumn = 0;
		int lastColumn = 0;
		for (int i = 0; i < firstAndLastIndexInfoInColumn.length; i++) {
			if (minRow != firstAndLastIndexInfoInColumn[i][0]
					&& maxRow != firstAndLastIndexInfoInColumn[i][1]) {
				firstColumn = i;
				minRow = firstAndLastIndexInfoInColumn[i][0];
				maxRow = firstAndLastIndexInfoInColumn[i][1];
			}
		}
	}

}
