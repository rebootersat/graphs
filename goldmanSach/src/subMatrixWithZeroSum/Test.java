package subMatrixWithZeroSum;

public class Test {

	public static void main(String[] args) {
		
		int[][] arr = {{9,7,16,5},{1,-6,-7,3},{1,8,7,9},{7,-2,0,10}};
		
		SubMatrix matrix = new SubMatrix(arr);
		matrix.initFirstAndLastIndexForZeroSumInEachRow();
		matrix.initFirstAndLastIndexForZeroSumInEachColumn();
		matrix.subMatrixRowWise();
		matrix.subMatrixColumnWise();
		System.out.println(matrix);
	}
	
}
