package codingForFun;

// Given an NxN matrix with unique integers :Find and print positions of all numbers such that it is the biggest in its row and also the smallest in its column.
// e.g. : In 3 x 3 with elements 
// 1 2 3 
// 4 5 6 
// 7 8 9
// the number is 3 and position (1,3)
public class MatrixPosition_25 {

	public void findMatrixPosition(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			int maxj = 0;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < len; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
					maxj = j;
				}
			}
			int mini = 0;
			while (mini < len && matrix[mini][maxj] >= max) {
				mini++;
			}
			if (mini == len) {
				System.out.println("(" + (i + 1) + ", " + (maxj + 1) + ")");
			}
		}
	}
	
	public static void main(String[] args) {
		MatrixPosition_25 mp = new MatrixPosition_25();
		int[][] matrix = new int[][] {{1,2,3,4,5},{10,11,12,13,14},{20,21,22,23,24,25},{34,45,56,67,78},{101,102,103,104,105}};
		mp.findMatrixPosition(matrix);
	}
	
/*
  static public void printSaddlePoint(int[][] input){
	int numRow = input.length();
	int numCol = input[0].length();
	
	int[numRow] maxRowIdx;
	int[numCol] minColIdx;
	
	int[numCol] minColVal;
	for (int j=0; j<numCol; ++j){minColVal[j] = Integer.MAX_VALUE;}
	
	for (int i=0; i<numRow; ++i){
		int tempMinVal = Integer.MIN_VALUE;
		for (int j=0; j<numCol; ++j){
			if (input[i][j] > tempMinVal){
				maxRowIdx[i] = j;
				tempMinVal = input[i][j];
			}
			if (input[i][j] < minColVal[j]){
				minColIdx[j] = j;
				minColVal[j] = input[i][j];
			}
		}
	}
	
	for (int i=0; i<numRow; ++i){
		if (maxColIdx[maxRowIdx[i]] == i){
			System.out.println("Saddle point found at Row: " + i + ", Col: " + j + ";" );
		}
	}
}
*/
	
}
